/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ru.subscribe.pro.api.command.Action;
import ru.subscribe.pro.api.command.BaseCommand;
import ru.subscribe.pro.api.command.Const;
import ru.subscribe.pro.api.command.ErrorCode;
import ru.subscribe.pro.api.dto.ActionPolicy;
import ru.subscribe.pro.api.dto.AddressType;
import ru.subscribe.pro.api.dto.ApiError;
import ru.subscribe.pro.api.dto.Format;
import ru.subscribe.pro.api.dto.GroupType;
import ru.subscribe.pro.api.dto.RfsDomain;
import ru.subscribe.pro.api.exception.BaseException;
import ru.subscribe.pro.api.exception.NeedChangePasswordException;
import ru.subscribe.pro.api.exception.TooManyRedirectionException;
import ru.subscribe.pro.api.exception.UnauthorizedException;
import ru.subscribe.pro.api.utils.DataExtractUtils;

/**
 * Connection.
 *
 * @author Yuri Rychkov
 */
public class Connection {
    /**
     * Max redirect count.
     */
    public static final int MAX_REDIRECT_COUNT = 10;

    private static final Logger LOGGER = LoggerFactory.getLogger(Connection.class);

    private static final JsonSerializer<Action> ACTION_JSON_SERIALIZER = new JsonSerializer<Action>() {
        @Override
        public JsonElement serialize(Action action, Type type, JsonSerializationContext jsonSerializationContext) {
            return action == null ? JsonNull.INSTANCE : new JsonPrimitive(action.getValue());
        }
    };
    private static final JsonSerializer<GroupType> GROUP_TYPE_JSON_SERIALIZER = new JsonSerializer<GroupType>() {
        @Override
        public JsonElement serialize(GroupType groupType, Type type, JsonSerializationContext jsonSerializationContext) {
            return groupType == null ? JsonNull.INSTANCE : new JsonPrimitive(groupType.getValue());
        }
    };
    private static final JsonSerializer<AddressType> ADDRESS_TYPE_JSON_SERIALIZER = new JsonSerializer<AddressType>() {
        @Override
        public JsonElement serialize(AddressType addressType, Type type, JsonSerializationContext jsonSerializationContext) {
            return addressType == null ? JsonNull.INSTANCE : new JsonPrimitive(addressType.getValue());
        }
    };
    private static final JsonSerializer<ActionPolicy> ACTION_POLICY_JSON_SERIALIZER = new JsonSerializer<ActionPolicy>() {
        @Override
        public JsonElement serialize(ActionPolicy policy, Type type, JsonSerializationContext jsonSerializationContext) {
            return policy == null ? JsonNull.INSTANCE : new JsonPrimitive(policy.getValue());
        }
    };
    private static final JsonSerializer<RfsDomain> RFS_DOMAIN_JSON_SERIALIZER = new JsonSerializer<RfsDomain>() {
        @Override
        public JsonElement serialize(RfsDomain domain, Type type, JsonSerializationContext jsonSerializationContext) {
            return domain == null ? JsonNull.INSTANCE : new JsonPrimitive(domain.getValue());
        }
    };

    private static final JsonSerializer<Format> FORMAT_JSON_SERIALIZER = new JsonSerializer<Format>() {
        @Override
        public JsonElement serialize(Format format, Type type, JsonSerializationContext jsonSerializationContext) {
            return format == null ? JsonNull.INSTANCE : new JsonPrimitive(format.getValue());
        }
    };

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Action.class, ACTION_JSON_SERIALIZER)
            .registerTypeAdapter(GroupType.class, GROUP_TYPE_JSON_SERIALIZER)
            .registerTypeAdapter(AddressType.class, ADDRESS_TYPE_JSON_SERIALIZER)
            .registerTypeAdapter(ActionPolicy.class, ACTION_POLICY_JSON_SERIALIZER)
            .registerTypeAdapter(RfsDomain.class, RFS_DOMAIN_JSON_SERIALIZER)
            .registerTypeAdapter(Format.class, FORMAT_JSON_SERIALIZER)
            .create();

    private static final JsonParser PARSER = new JsonParser();

    private int redirectCount = 0;
    private String redirectSuffix = "";
    private AtomicLong counter = new AtomicLong();
    private HttpClient httpClient;

    /**
     * Constructor.
     *
     * @param httpClient http client
     */
    public Connection(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Sends command.
     *
     * @param cmd command
     * @return response result
     * @throws java.io.IOException if IO errors occurred
     * @throws ru.subscribe.pro.api.exception.BaseException       on API error
     */
    protected JsonElement sendCommand(BaseCommand cmd) throws IOException, BaseException {
        return sendInternal(cmd, getRequestId());
    }

    private JsonElement sendInternal(BaseCommand cmd, long requestId) throws IOException, BaseException {
        try {
            String value = GSON.toJson(cmd);
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Request value: {}", value);
            }
            URI uri = new URIBuilder(Const.BASE_API_URL.getDefaultValue() + redirectSuffix)
                    .addParameter(Const.API_VERSION.getParamName(), Const.API_VERSION.getDefaultValue())
                    .addParameter(Const.JSON.getParamName(), Const.JSON.getDefaultValue())
                    .addParameter(Const.REQUEST_ID.getParamName(), Long.toHexString(requestId))
                    .addParameter(Const.REQUEST.getParamName(), value)
                    .build();

            HttpPost post = new HttpPost(uri);
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("REQUEST: {}", post);
            }
            HttpResponse httpResponse = httpClient.execute(post);
            HttpEntity entity = httpResponse.getEntity();
            String json = EntityUtils.toString(entity);
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("RESPONSE: {}", json);
            }
            long start = System.currentTimeMillis();
            JsonElement cmdResponse = PARSER.parse(json);
            long stop = System.currentTimeMillis();
            LOGGER.trace("Response gson -> {} | {}", (stop - start), cmdResponse);
            String redirect = DataExtractUtils.getRedirect(cmdResponse);
            if (StringUtils.isNotBlank(redirect)) {
                redirectCount++;
                redirectSuffix = redirect;
                checkRedirectCount();
                return sendInternal(cmd, getRequestId());
            } else {
                checkAuthError(cmdResponse);
            }
            return cmdResponse;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkAuthError(JsonElement cmdResponse) throws BaseException {
        Collection<ApiError> apiErrors = DataExtractUtils.getErrors(cmdResponse);
        if (!apiErrors.isEmpty()) {
            for (ApiError e : apiErrors) {
                if (ErrorCode.resolveById(e.getId()) == ErrorCode.AUTH_FAILED) {
                    //TODO use const
                    if ("force_change_password".equals(e.getExplain())) {
                        throw new NeedChangePasswordException(e);
                    }
                    throw new UnauthorizedException(e, cmdResponse);
                }
            }
        }
    }

    private void checkRedirectCount() throws TooManyRedirectionException {
        if (redirectCount > MAX_REDIRECT_COUNT) {
            throw new TooManyRedirectionException(redirectCount);
        }
    }

    private long getRequestId() {
        return counter.getAndIncrement();
    }
}

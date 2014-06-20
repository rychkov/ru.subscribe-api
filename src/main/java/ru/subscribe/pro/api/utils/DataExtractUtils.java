/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ru.subscribe.pro.api.command.Const;
import ru.subscribe.pro.api.dto.AddressType;
import ru.subscribe.pro.api.dto.ApiError;
import ru.subscribe.pro.api.dto.Group;
import ru.subscribe.pro.api.dto.GroupType;
import ru.subscribe.pro.api.dto.SmtpInfo;
import ru.subscribe.pro.api.dto.SmtpStatus;
import ru.subscribe.pro.api.dto.SubscriptionInfo;

/**
 * Utils for data extraction from responses.
 *
 * @author Yuri Rychkov
 */
public final class DataExtractUtils {
    private DataExtractUtils() {
    }

    /**
     * Gets redirect part.
     *
     * @param cmdResponse parsed command response
     * @return redirect part
     */
    public static String getRedirect(JsonElement cmdResponse) {
        return getStringValue(cmdResponse, Const.REDIRECT);
    }

    /**
     * Gets session id.
     *
     * @param cmdResponse parsed command response
     * @return session id
     */
    public static String getSessionId(JsonElement cmdResponse) {
        return getStringValue(cmdResponse, Const.SESSION);
    }

    /**
     * Gets errors.
     *
     * @param cmdResponse parsed command response
     * @return error errors collection or empty, never {@code null}
     */
    public static List<ApiError> getErrors(JsonElement cmdResponse) {
        List<ApiError> apiErrors;
        JsonArray items = getList(cmdResponse, Const.ERRORS);
        if (items != null && items.size() > 0) {
            apiErrors = new ArrayList<>(items.size());
            for (JsonElement entry : items) {
                ApiError e = getSingleError(entry);
                apiErrors.add(e);
            }
        } else {
            apiErrors = Collections.emptyList();
        }
        return apiErrors;
    }

    /**
     * Gets error.
     *
     * @param cmdResponse parsed command response
     * @return error or Error.NO_ERROR if no error
     */
    public static ApiError getError(JsonElement cmdResponse) {
        List<ApiError> apiErrors = getErrors(cmdResponse);
        return apiErrors.isEmpty() ? ApiError.NO_API_ERROR : apiErrors.get(0);
    }

    private static ApiError getSingleError(JsonElement item) {
        String id = getStringValue(item, Const.ID);
        String explain = getStringValue(item, Const.EXPLAIN);
        return new ApiError(id, explain);
    }

    /**
     * Gets group list.
     *
     * @param cmdResponse parsed command response
     * @return group list, never {@code null}
     */
    public static List<Group> getGroupList(JsonElement cmdResponse) {
        List<Group> result = new ArrayList<>();
        JsonArray items = getList(cmdResponse, Const.LIST);
        if (items != null && items.size() > 0) {
            for (JsonElement item : items) {
                result.add(getSingleGroup(item.getAsJsonObject()));
            }
        }
        return result;
    }

    /**
     * Gets group info.
     *
     * @param cmdResponse parsed command response
     * @return group info or {@code null}
     */
    public static Group getGroup(JsonElement cmdResponse) {
        JsonObject entry = getMap(cmdResponse, Const.OBJECT);
        return entry == null ? null : getSingleGroup(entry);
    }

    private static Group getSingleGroup(JsonObject entry) {
        String id = getStringValue(entry, Const.ID);
        String name = getStringValue(entry, Const.NAME);
        GroupType type = GroupType.resolveByValue(getStringValue(entry, Const.GROUP_TYPE));
        AddressType addressType = AddressType.resolveByValue(getStringValue(entry, Const.ADDRESS_TYPE));
        return new Group(id, name, type, addressType);
    }

    /**
     * Gets SmtpInfo map.
     *
     * @param cmdResponse parsed command response
     * @return map, never {@code null}
     */
    public static Map<String, SmtpInfo> getSmtpInfoMap(JsonElement cmdResponse) {
        JsonObject email2infoMap = getMap(cmdResponse, Const.LIST);
        Set<Map.Entry<String, JsonElement>> entries = email2infoMap.entrySet();
        if (entries.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, SmtpInfo> result = new HashMap<>(entries.size());
        for (Map.Entry<String, JsonElement> entry : entries) {
            result.put(entry.getKey(), getSmtpInfo(entry.getValue()));
        }
        return result;
    }

    private static SmtpInfo getSmtpInfo(JsonElement value) {
        String email = getStringValue(value, Const.EMAIL);
        String syntax = getStringValue(value, Const.SYNTAX);

        JsonObject smtp = getMap(value, Const.SMTP);

        SmtpStatus status = null;
        String domain = null;
        String mx = null;
        String ip = null;
        List<String> ptr = null;
        String code = null;
        String dsn = null;
        String message = null;

        if (smtp != null) {
            String stringValue = getStringValue(smtp, Const.STATUS);
            status = stringValue == null ? null : SmtpStatus.resolveByValue(stringValue);
            domain = getStringValue(smtp, Const.DOMAIN);
            mx = getStringValue(smtp, Const.MX);
            ip = getStringValue(smtp, Const.IP);
            JsonArray prtArray = getList(smtp, Const.PTR);
            if (prtArray != null && prtArray.size() > 0) {
                ptr = new ArrayList<>(prtArray.size());
                for (JsonElement aPrtArray : prtArray) {
                    ptr.add(aPrtArray.getAsString());
                }
            }
            code = getStringValue(smtp, Const.CODE);
            dsn = getStringValue(smtp, Const.DSN);
            message = getStringValue(smtp, Const.MESSAGE);
        }

        return new SmtpInfo(email, syntax, status, domain, mx, ip, ptr, code, dsn, message);
    }

    /**
     * Gets subscription list.
     *
     * @param cmdResponse parsed command response
     * @return subscription list, never {@code null}
     */
    public static List<? extends SubscriptionInfo> getSubscriptionList(JsonElement cmdResponse) {
        List<SubscriptionInfo> result = new ArrayList<>();
        JsonArray items = getList(cmdResponse, Const.LIST);
        if (items != null && items.size() > 0) {
            for (JsonElement item : items) {
                result.add(getSubscriptionInfo(item));
            }
        }
        return result;
    }

    private static SubscriptionInfo getSubscriptionInfo(JsonElement entry) {
        String id = getStringValue(entry, Const.ID);
        String name = getStringValue(entry, Const.NAME);
        boolean system = getBoolean(entry, Const.SYSTEM);
        return new SubscriptionInfo(id, name, system);
    }

    /**
     * Gets boolean value.
     *
     * @param cmdResponse parsed command response
     * @param key key
     * @return value
     */
    public static boolean getBoolean(JsonElement cmdResponse, Const key) {
        return Integer.parseInt(getStringValue(cmdResponse, key)) != 0;
    }

    private static JsonArray getList(JsonElement cmdResponse, Const key) {
        JsonElement jsonElement = cmdResponse.getAsJsonObject().get(key.getParamName());
        return jsonElement == null ? null : jsonElement.getAsJsonArray();
    }

    private static JsonObject getMap(JsonElement cmdResponse, Const key) {
        JsonElement jsonElement = cmdResponse.getAsJsonObject().get(key.getParamName());
        return jsonElement == null ? null : jsonElement.getAsJsonObject();
    }

    private static String getStringValue(JsonElement cmdResponse, Const key) {
        JsonElement jsonElement = cmdResponse.getAsJsonObject().get(key.getParamName());
        return jsonElement == null ? null : jsonElement.getAsString();
    }
}

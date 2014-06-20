/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */
package ru.subscribe.pro.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;

import ru.subscribe.pro.api.command.BaseCommand;
import ru.subscribe.pro.api.command.CreateGroup;
import ru.subscribe.pro.api.command.DeleteGroup;
import ru.subscribe.pro.api.command.GetGroup;
import ru.subscribe.pro.api.command.GetGroupList;
import ru.subscribe.pro.api.command.GetSubscriptionsList;
import ru.subscribe.pro.api.command.Login;
import ru.subscribe.pro.api.command.Logout;
import ru.subscribe.pro.api.command.Ping;
import ru.subscribe.pro.api.command.Pong;
import ru.subscribe.pro.api.command.SetGroupMember;
import ru.subscribe.pro.api.command.TestEmail;
import ru.subscribe.pro.api.dto.ActionPolicy;
import ru.subscribe.pro.api.dto.AddressType;
import ru.subscribe.pro.api.dto.ApiError;
import ru.subscribe.pro.api.dto.Group;
import ru.subscribe.pro.api.dto.SmtpInfo;
import ru.subscribe.pro.api.dto.SubscriptionInfo;
import ru.subscribe.pro.api.exception.BaseApiErrorException;
import ru.subscribe.pro.api.exception.BaseException;
import ru.subscribe.pro.api.exception.WrongSessionIdException;
import ru.subscribe.pro.api.utils.DataExtractUtils;

/**
 * Session.
 *
 * @author Yuri Rychkov
 */
public class Session {
    private static final Logger LOGGER = LoggerFactory.getLogger(Session.class);
    private Connection connection;
    private String id = "";

    /**
     * Constructor.
     *
     * @param httpClient http client
     */
    public Session(HttpClient httpClient) {
        this.connection = new Connection(httpClient);
    }

    /**
     * Get session id.
     *
     * @return session id or {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * Performs login.
     *
     * @param login login
     * @param subLogin sub login
     * @param password password
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    void login(String login, String subLogin, String password) throws IOException, BaseException {
        Login cmd = new Login(login, subLogin, password);
        sendCommand(cmd);
    }

    /**
     * Performs logout.
     *
     * @throws java.io.IOException if IO errors occurred
     */
    public void logout() throws IOException {
        Logout cmd = new Logout(getId());
        try {
            sendCommand(cmd);
        } catch (BaseException e) {
            LOGGER.warn("{}", e);
        }
    }

    /**
     * Ping.
     *
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public void ping() throws IOException, BaseException {
        Ping cmd = new Ping();
        sendCommand(cmd, false);
    }

    /**
     * Pong. Authorized version of ping.
     *
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public void pong() throws IOException, BaseException {
        Pong cmd = new Pong(getId());
        sendCommandAndCheckErrors(cmd);
    }

    /**
     * Gets subscriptions lists.
     *
     * @return subscriptions list
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public List<? extends SubscriptionInfo> getSubscriptionsList() throws IOException, BaseException {
        GetSubscriptionsList cmd = new GetSubscriptionsList(getId());
        JsonElement response = sendCommandAndCheckErrors(cmd);
        return DataExtractUtils.getSubscriptionList(response);
    }

//    /**
//     * Gets subscription info.
//     *
//     * @param subscriptionId subscription id
//     * @throws java.io.IOException if IO errors occurred
//     * @throws BaseException       on API error
//     */
//    public void getSubscription(String subscriptionId) throws IOException, BaseException {
//        GetSubscription cmd = new GetSubscription(getId(), subscriptionId);
//        JsonElement response = sendCommand(cmd);
//        //FIXME
//        response.toString();
//    }

//    /**
//     * Gets member info.
//     *
//     * @param email user email
//     * @throws java.io.IOException if IO errors occurred
//     * @throws BaseException       on API error
//     */
//    public void getMember(String email) throws IOException, BaseException {
//        GetMember cmd = new GetMember(getId(), email);
//        JsonElement response = sendCommand(cmd);
//        //FIXME
//        response.toString();
//    }

    /**
     * Gets group list.
     *
     * @return group list, never {@code null}
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public List<Group> getGroupList() throws IOException, BaseException {
        GetGroupList cmd = new GetGroupList(getId());
        JsonElement response = sendCommandAndCheckErrors(cmd);
        return DataExtractUtils.getGroupList(response);
    }

    /**
     * Gets group info.
     *
     * @param groupId group id
     * @return group info or null
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public Group getGroup(String groupId) throws IOException, BaseException {
        GetGroup cmd = new GetGroup(getId(), groupId);
        JsonElement response = sendCommandAndCheckErrors(cmd);
        return DataExtractUtils.getGroup(response);
    }

    /**
     * Creates group.
     *
     * @param group group info
     * @return Error#NO_ERROR if success or other error
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public ApiError createGroup(Group group) throws IOException, BaseException {
        return createGroup(group, null);
    }

    /**
     * Creates group.
     *
     * @param group group info
     * @param issuePassword issue password
     * @return Error#NO_ERROR if success or other error
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public ApiError createGroup(Group group, String issuePassword) throws IOException, BaseException {
        CreateGroup cmd = new CreateGroup(getId(), group, issuePassword);
        JsonElement response = sendCommandAndCheckErrors(cmd);
        return DataExtractUtils.getError(response);
    }

    /**
     * Delete group.
     *
     * @param groupId group id
     * @return Error#NO_ERROR if success or other error
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public ApiError deleteGroup(String groupId) throws IOException, BaseException {
        DeleteGroup cmd = new DeleteGroup(getId(), groupId);
        JsonElement response = sendCommandAndCheckErrors(cmd);
        return DataExtractUtils.getError(response);
    }

    /**
     * Test emails list.
     *
     * @param emails collection of email
     * @return map email to SmtpInfo
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public Map<String, SmtpInfo> testEmails(List<String> emails) throws IOException, BaseException {
        TestEmail cmd = new TestEmail(getId(), emails);
        JsonElement response = sendCommandAndCheckErrors(cmd);
        return DataExtractUtils.getSmtpInfoMap(response);
    }

    /**
     * Add member to groups.
     *
     * @param address address
     * @param type address type
     * @param groupIds group ids
     * @param ip user ip or server ip
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public void addGroupMember(String address, AddressType type, List<String> groupIds, String ip) throws IOException, BaseException {
        SetGroupMember cmd = new SetGroupMember(getId(), address, type, ActionPolicy.UPDATE, groupIds, null, ip);
        sendCommandAndCheckErrors(cmd);
    }

    /**
     * Delete member from groups.
     *
     * @param address address
     * @param type address type
     * @param groupIds group ids
     * @param ip user ip or server ip
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public void deleteGroupMember(String address, AddressType type, List<String> groupIds, String ip) throws IOException, BaseException {
        SetGroupMember cmd = new SetGroupMember(getId(), address, type, ActionPolicy.UPDATE, null, groupIds, ip);
        sendCommandAndCheckErrors(cmd);
    }

    /**
     * Set member for includeGroupIds groups and remove from excludeGroupIds groups.
     *
     * @param address address
     * @param type address type
     * @param includeGroupIds include group ids
     * @param excludeGroupIds exclude group ids
     * @param ip user ip or server ip
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public void setGroupMember(String address, AddressType type, List<String> includeGroupIds, List<String> excludeGroupIds,
                               String ip) throws IOException, BaseException {
        SetGroupMember cmd = new SetGroupMember(getId(), address, type, ActionPolicy.UPDATE, includeGroupIds, excludeGroupIds, ip);
        sendCommandAndCheckErrors(cmd);
    }

    private void checkAndSetSessionId(JsonElement cmdResponse) throws BaseException {
        String cmdResponseSessionId = DataExtractUtils.getSessionId(cmdResponse);
        if (StringUtils.isEmpty(id) && cmdResponseSessionId != null) {
            id = cmdResponseSessionId;
            return;
        }
        if (cmdResponseSessionId != null && !cmdResponseSessionId.equalsIgnoreCase(id)) {
            throw new WrongSessionIdException(cmdResponseSessionId);
        }
    }

    private JsonElement sendCommand(BaseCommand cmd) throws IOException, BaseException {
        return sendCommand(cmd, true);
    }

    private JsonElement sendCommand(BaseCommand cmd, boolean checkSession) throws IOException, BaseException {
        JsonElement result = connection.sendCommand(cmd);
        if (checkSession) {
            checkAndSetSessionId(result);
        }
        return result;
    }

    private void checkErrors(JsonElement cmdResponse) throws BaseException {
        List<ApiError> apiErrors = DataExtractUtils.getErrors(cmdResponse);
        if (!apiErrors.isEmpty()) {
            throw new BaseApiErrorException(apiErrors.get(0));
        }
    }

    private JsonElement sendCommandAndCheckErrors(BaseCommand cmd) throws IOException, BaseException {
        JsonElement cmdResponse = sendCommand(cmd);
        checkErrors(cmdResponse);
        return cmdResponse;
    }
}
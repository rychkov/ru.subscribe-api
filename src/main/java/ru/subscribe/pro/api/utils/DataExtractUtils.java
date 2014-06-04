/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.subscribe.pro.api.command.Const;
import ru.subscribe.pro.api.dto.AddressType;
import ru.subscribe.pro.api.dto.Error;
import ru.subscribe.pro.api.dto.Group;
import ru.subscribe.pro.api.dto.GroupType;

/**
 * Utils for data extraction from responses.
 *
 * @author Yuri Rychkov
 */
public final class DataExtractUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataExtractUtils.class);

    private DataExtractUtils() {
    }

    /**
     * Gets redirect part.
     *
     * @param cmdResponse parsed command response
     * @return redirect part
     */
    public static String getRedirect(Object cmdResponse) {
        return getStringValue((Map<String, String>) cmdResponse, Const.REDIRECT);
    }

    /**
     * Gets session id.
     *
     * @param cmdResponse parsed command response
     * @return session id
     */
    public static String getSessionId(Object cmdResponse) {
        return getStringValue((Map<String, String>) cmdResponse, Const.SESSION);
    }

    /**
     * Gets errors.
     *
     * @param cmdResponse parsed command response
     * @return error errors collection or empty, never {@code null}
     */
    public static List<Error> getErrors(Object cmdResponse) {
        List<Error> errors;
        Collection<Map<String, String>> errorsObj = ((Map<String, Collection<Map<String, String>>>) cmdResponse).get(Const.ERRORS.getParamName());
        if (errorsObj != null) {
            errors = new ArrayList<>(errorsObj.size());
            for (Map<String, String> item : errorsObj) {
                String id = getStringValue(item, Const.ID);
                String explain = getStringValue(item, Const.EXPLAIN);

                Error e = new Error(id, explain);
                errors.add(e);
            }
        } else {
            errors = Collections.emptyList();
        }
        return errors;
    }

    /**
     * Gets group list.
     *
     * @param cmdResponse parsed command response
     * @return group list, never {@code null}
     */
    public static List<Group> getGroupList(Object cmdResponse) {
        List<Group> result = new ArrayList<>();
        List<Map<String, String>> items = getList((Map<String, List<Map<String, String>>>) cmdResponse, Const.LIST);
        if (items != null) {
            for (Map<String, String> entry : items) {
                result.add(getGroup(entry));
            }
        }
        return result;
    }

    private static Group getGroup(Map<String, String> entry) {
        String id = getStringValue(entry, Const.ID);
        String name = getStringValue(entry, Const.NAME);
        GroupType type = GroupType.resolveByValue(getStringValue(entry, Const.GROUP_TYPE));
        AddressType addressType = AddressType.resolveByValue(getStringValue(entry, Const.ADDRESS_TYPE));
        return new Group(id, name, type, addressType);
    }

    private static <T> List<T> getList(Map<String, List<T>> cmdResponse, Const key) {
        return cmdResponse.get(key.getParamName());
    }

    private static String getStringValue(Map<String, String> cmdResponse, Const key) {
        return ((Map<String, String>) cmdResponse).get(key.getParamName());
    }
}

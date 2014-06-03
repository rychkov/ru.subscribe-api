/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.utils;

import java.util.Map;

import ru.subscribe.pro.api.command.Const;

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

    private static String getStringValue(Map<String, String> cmdResponse, Const key) {
        return ((Map<String, String>) cmdResponse).get(key.getParamName());
    }
}

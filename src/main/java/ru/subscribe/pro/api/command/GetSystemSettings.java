/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get system settings.
 *
 * @author Yuri Rychkov
 */
public class GetSystemSettings extends SessionCommand {
    //TODO add list & param

    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetSystemSettings(String sessionId) {
        super(Action.SYS_SETTINGS_GET, sessionId);
    }
}

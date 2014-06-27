/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import com.google.gson.annotations.SerializedName;

/**
 * Session base command class.
 *
 * @author Yuri Rychkov
 */
public abstract class SessionCommand extends BaseCommand {
    @SerializedName("session")
    private String sessionId;

    /**
     * Constructor.
     *
     * @param action action
     * @param sessionId session id
     */
    public SessionCommand(Action action, String sessionId) {
        super(action);
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}

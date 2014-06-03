/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */
package ru.subscribe.pro.api.command;

/**
 * Logout command.
 *
 * @author Yuri Rychkov
 */
public class Logout extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public Logout(String sessionId) {
        super(Action.LOGOUT, sessionId);
    }
}

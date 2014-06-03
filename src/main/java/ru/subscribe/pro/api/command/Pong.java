/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Unauthorized ping.
 *
 * @author Yuri Rychkov
 */
public class Pong extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public Pong(String sessionId) {
        super(Action.PONG, sessionId);
    }
}

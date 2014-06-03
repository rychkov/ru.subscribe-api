/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

/**
 * Wrong session id.
 *
 * @author Yuri Rychkov
 */
public class WrongSessionIdException extends BaseException {
    private String sessionId;

    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public WrongSessionIdException(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}

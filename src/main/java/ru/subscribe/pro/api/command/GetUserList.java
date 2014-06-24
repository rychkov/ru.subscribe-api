/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get user list.
 *
 * @author Yuri Rychkov
 */
public class GetUserList extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetUserList(String sessionId) {
        super(Action.USER_LIST, sessionId);
    }
}

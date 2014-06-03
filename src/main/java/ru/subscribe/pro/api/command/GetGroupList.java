/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Gets group list.
 *
 * @author Yuri Rychkov
 */
public class GetGroupList extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetGroupList(String sessionId) {
        super(Action.GROUP_LIST, sessionId);
    }
}

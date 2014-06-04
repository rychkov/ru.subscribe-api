/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Delete group.
 *
 * @author Yuri Rychkov
 */
public class DeleteGroup extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id group id
     */
    public DeleteGroup(String sessionId, String id) {
        super(Action.GROUP_DELETE, sessionId);
        this.id = id;
    }
}

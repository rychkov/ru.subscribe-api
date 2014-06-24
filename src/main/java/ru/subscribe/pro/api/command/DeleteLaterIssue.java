/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Delete later issue.
 *
 * @author Yuri Rychkov
 */
public class DeleteLaterIssue extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id issue id
     */
    public DeleteLaterIssue(String sessionId, String id) {
        super(Action.ISSUE_LATER_DELETE, sessionId);
        this.id = id;
    }
}

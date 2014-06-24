/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get later issue.
 *
 * @author Yuri Rychkov
 */
public class GetLaterIssue extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id issue id
     */
    public GetLaterIssue(String sessionId, String id) {
        super(Action.ISSUE_LATER_GET, sessionId);
        this.id = id;
    }
}

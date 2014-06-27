/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Delete issue draft.
 *
 * @author Yuri Rychkov
 */
public class DeleteIssueDraft extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id draft id
     */
    public DeleteIssueDraft(String sessionId, String id) {
        super(Action.ISSUE_DRAFT_DELETE, sessionId);
        this.id = id;
    }
}

/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get issue draft.
 *
 * @author Yuri Rychkov
 */
public class GetIssueDraft extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id issue draft id
     */
    public GetIssueDraft(String sessionId, String id) {
        super(Action.ISSUE_DRAFT_GET, sessionId);
        this.id = id;
    }
}

/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Gets issue draft list.
 *
 * @author Yuri Rychkov
 */
public class GetIssueDraftList extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetIssueDraftList(String sessionId) {
        super(Action.ISSUE_DRAFT_LIST, sessionId);
    }
}

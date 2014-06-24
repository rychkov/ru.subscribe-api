/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get link list.
 *
 * @author Yuri Rychkov
 */
public class GetLinkList extends SessionCommand {
    //TODO add filter

    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetLinkList(String sessionId) {
        super(Action.LINK_LIST, sessionId);
    }
}

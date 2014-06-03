/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get subscriptions list.
 *
 * @author Yuri Rychkov
 */
public class GetSubscriptionsList extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetSubscriptionsList(String sessionId) {
        super(Action.ANKETA_LIST, sessionId);
    }
}

/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get subscription info.
 *
 * @author Yuri Rychkov
 */
public class GetSubscription extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id subscription id
     */
    public GetSubscription(String sessionId, String id) {
        super(Action.ANKETA_GET, sessionId);
        this.id = id;
    }
}

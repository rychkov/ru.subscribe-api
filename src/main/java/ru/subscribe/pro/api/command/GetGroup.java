/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get group info.
 *
 * @author Yuri Rychkov
 */
public class GetGroup extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id group id
     */
    public GetGroup(String sessionId, String id) {
        super(Action.GROUP_GET, sessionId);
        this.id = id;
    }
}

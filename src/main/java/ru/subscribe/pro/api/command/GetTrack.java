/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get track.
 *
 * @author Yuri Rychkov
 */
public class GetTrack extends SessionCommand {
    private String id;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param id track id
     */
    public GetTrack(String sessionId, String id) {
        super(Action.TRACK_GET, sessionId);
        this.id = id;
    }
}

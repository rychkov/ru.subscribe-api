/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Get track list.
 *
 * @author Yuri Rychkov
 */
public class GetTrackList extends SessionCommand {
    //TODO add filter
    private Map<String, Object> filter = new HashMap<>();

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param filteredAction filtered action
     */
    public GetTrackList(String sessionId, Action filteredAction) {
        super(Action.TRACK_LIST, sessionId);
        this.filter.put("action", filteredAction);
    }
}

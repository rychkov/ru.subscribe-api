/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get format list.
 *
 * @author Yuri Rychkov
 */
public class GetFormatList extends SessionCommand {
    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetFormatList(String sessionId) {
        super(Action.FORMAT_LIST, sessionId);
    }
}

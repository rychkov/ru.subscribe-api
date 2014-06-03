/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Get member info.
 *
 * @author Yuri Rychkov
 */
public class GetMember extends SessionCommand {
    private String email;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param email email
     */
    public GetMember(String sessionId, String email) {
        super(Action.MEMBER_GET, sessionId);
        this.email = email;
    }
}

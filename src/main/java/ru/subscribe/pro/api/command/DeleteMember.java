/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Delete member info.
 *
 * @author Yuri Rychkov
 */
public class DeleteMember extends SessionCommand {
    private String email;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param email email
     */
    public DeleteMember(String sessionId, String email) {
        super(Action.MEMBER_DELETE, sessionId);
        this.email = email;
    }
}

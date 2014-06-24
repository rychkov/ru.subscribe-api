/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Send mail to support.
 *
 * @author Yuri Rychkov
 */
public class SendMailToSupport extends SessionCommand {
    private String email;
    private String message;
    //TODO add attach

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param email sender mail
     * @param message message
     */
    public SendMailToSupport(String sessionId, String email, String message) {
        super(Action.SYS_MESSAGE, sessionId);
        this.email = email;
        this.message = message;
    }
}

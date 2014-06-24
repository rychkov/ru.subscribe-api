/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Send mail to Ded Moroz AKA Santa Claus.
 *
 * @author Yuri Rychkov
 */
public class SendMailToSanta extends SessionCommand {
    private String email;
    private String message;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param email sender mail
     * @param message message
     */
    public SendMailToSanta(String sessionId, String email, String message) {
        super(Action.SYS_DEDMOROZ, sessionId);
        this.email = email;
        this.message = message;
    }
}

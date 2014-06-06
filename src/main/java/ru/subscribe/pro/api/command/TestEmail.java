/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import java.util.Collection;

import com.google.gson.annotations.SerializedName;

/**
 * Test emails.
 *
 * @author Yuri Rychkov
 */
public class TestEmail extends SessionCommand {
    private Collection<String> list;
    @SerializedName("smtp.test")
    private String testAvailabilityViaSMTP;
    @SerializedName("smtp.timeout")
    private Long smtpTimeoutInSeconds;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param emails email collection
     */
    public TestEmail(String sessionId, Collection<String> emails) {
        this(sessionId, emails, true, null);
    }

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param emails email collection
     * @param testAvailability test availability via SMTP or not
     * @param timeout SMTP timeout in seconds
     */
    public TestEmail(String sessionId, Collection<String> emails, boolean testAvailability, Long timeout) {
        super(Action.EMAIL_TEST, sessionId);
        this.list = emails;
        this.testAvailabilityViaSMTP = testAvailability ? "1" : "0";
        this.smtpTimeoutInSeconds = timeout;
    }
}

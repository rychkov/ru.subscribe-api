/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * SMTP status.
 *
 * @author Yuri Rychkov
 */
public enum SmtpStatus {
    /** Ok. */
    OK("ok"),
    /** Can't resolve MX. */
    RESOLVE_FAILED("resolver"),
    /** No MA or A record. */
    NO_MX_A("nomxa"),
    /** Connection refused. */
    CONNECTION_REFUSED("connref"),
    /** Error in banner. */
    ERROR_IN_BANNER("banner"),
    /** Error in HELO response. */
    HELO("helo"),
    /** Error in MAIL FROM response. */
    MAIL_FROM("mailfrom"),
    /** Error in RCPT TO response. */
    RCPT_TO("rcptto");

    private final String value;

    private SmtpStatus(String value) {
        this.value = value;
    }

    /**
     * Resolve by value.
     * @param value value
     * @return status
     */
    public static SmtpStatus resolveByValue(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }
        for (SmtpStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("unknown value: " + value);
    }
}

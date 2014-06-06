/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * SMTP info about tested email.
 *
 * @author Yuri Rychkov
 */
public class SmtpInfo {
    private String email;
    private String syntax;
    private SmtpStatus status;
    private String domain;
    private String mx;
    private String ip;
    private List<String> ptr;
    private String code;
    private String dsn;
    private String message;

    /**
     * Constructor.
     *
     * @param email normalized email
     * @param syntax syntax status 'ok' or some error
     * @param status SMTP status
     * @param domain SMTP domain
     * @param mx SMTP MX
     * @param ip SMTP IP
     * @param ptr SMTP ptr's list
     * @param code SMTP code
     * @param dsn SMTP dsn
     * @param message SMTP message
     */
    public SmtpInfo(String email, String syntax, SmtpStatus status, String domain, String mx, String ip,
                    List<String> ptr, String code, String dsn, String message) {
        this.email = email;
        this.syntax = syntax;
        this.status = status;
        this.domain = domain;
        this.mx = mx;
        this.ip = ip;
        this.ptr = ptr;
        this.code = code;
        this.dsn = dsn;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getSyntax() {
        return syntax;
    }

    public SmtpStatus getStatus() {
        return status;
    }

    public String getDomain() {
        return domain;
    }

    public String getMx() {
        return mx;
    }

    public String getIp() {
        return ip;
    }

    public List<String> getPtr() {
        return Collections.unmodifiableList(ptr);
    }

    public String getCode() {
        return code;
    }

    public String getDsn() {
        return dsn;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

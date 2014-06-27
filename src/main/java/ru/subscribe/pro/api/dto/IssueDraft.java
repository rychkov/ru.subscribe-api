/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Issue draft.
 *
 * @author Yuri Rychkov
 */
public class IssueDraft extends IssueDraftInfo {
    private String division;
    private String from;
    private String sender;
    private String replayEmail;
    private String replayName;
    private String toName;
    private String subject;
    private String text;
    private String templateThumbnailUrl;

    /**
     * Constructor.
     *
     * @param id draft id
     * @param name name
     * @param template template
     * @param format format
     * @param division division
     * @param from from
     * @param sender sender
     * @param replayEmail replay email
     * @param replayName replay name
     * @param toName too name
     * @param subject subject
     * @param text text
     * @param templateThumbnailUrl template thumbnail url
     */
    public IssueDraft(String id, String name, boolean template, Format format, String division,
                      String from, String sender, String replayEmail, String replayName, String toName,
                      String subject, String text, String templateThumbnailUrl) {
        super(id, name, template, format);
        this.division = division;
        this.from = from;
        this.sender = sender;
        this.replayEmail = replayEmail;
        this.replayName = replayName;
        this.toName = toName;
        this.subject = subject;
        this.text = text;
        this.templateThumbnailUrl = templateThumbnailUrl;
    }

    public String getDivision() {
        return division;
    }

    public String getFrom() {
        return from;
    }

    public String getSender() {
        return sender;
    }

    public String getReplayEmail() {
        return replayEmail;
    }

    public String getReplayName() {
        return replayName;
    }

    public String getToName() {
        return toName;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getTemplateThumbnailUrl() {
        return templateThumbnailUrl;
    }
}

/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

import ru.subscribe.pro.api.dto.Format;

/**
 * Get later issue list.
 *
 * @author Yuri Rychkov
 */
public class GetLaterIssueList extends SessionCommand {
    private String from;
    @SerializedName("upto")
    private String upTo;
    //TODO add group filter
    private Format format;

    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public GetLaterIssueList(String sessionId) {
        this(sessionId, null, null, null);
    }

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param format format
     * @param fromDate from date
     * @param upToDate up to date
     *
     * @see {@link ru.subscribe.pro.api.dto.Format }
     */
    public GetLaterIssueList(String sessionId, Format format, Date fromDate, Date upToDate) {
        super(Action.ISSUE_LATER_LIST, sessionId);
        this.format = format;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        this.from = fromDate == null ? null : fmt.format(fromDate);
        this.upTo = upToDate == null ? null : fmt.format(upToDate);
    }
}

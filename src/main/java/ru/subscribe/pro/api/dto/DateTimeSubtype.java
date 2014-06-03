/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Date time subtype.
 *
 * @author Yuri Rychkov
 */
public enum DateTimeSubtype {
    /** Day precise.  */
    YEAR_MONTH_DAY("yd", "yyyy-MM-dd"),
    /** Hour precise . */
    YEAR_MONTH_DAY_HOUR("yh", "yyyy-MM-dd HH"),
    /** Minute precise. */
    YEAR_MONTH_DAY_HOUR_MINUTE("ym", "yyyy-MM-dd HH:mm"),
    /** Second precise. */
    YEAR_MONTH_DAY_HOUR_MINUTE_SECOND("ys", "yyyy-MM-dd HH:mm:ss");

    private final String value;
    private final String format;

    /**
     * Constructor.
     *
     * @param value value
     * @param format date time format
     */
    private DateTimeSubtype(String value, String format) {
        this.value = value;
        this.format = format;
    }

    public String getValue() {
        return value;
    }

    public String getFormat() {
        return format;
    }
}

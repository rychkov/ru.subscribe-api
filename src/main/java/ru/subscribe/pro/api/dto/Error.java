/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Error DTO.
 *
 * @author Yuri Rychkov
 */
public class Error {
    /** No error special value. */
    public static final Error NO_ERROR = new Error("-", "-");

    private String id;
    private String explain;

    /**
     * Constructor.
     *
     * @param id error id
     * @param explain text explain
     */
    public Error(String id, String explain) {
        this.id = id;
        this.explain = explain;
    }

    public String getId() {
        return id;
    }

    public String getExplain() {
        return explain;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

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
public class ApiError {
    /** No error special value. */
    public static final ApiError NO_API_ERROR = new ApiError("-", "-");

    private String id;
    private String explain;

    /**
     * Constructor.
     *
     * @param id error id
     * @param explain text explain
     */
    public ApiError(String id, String explain) {
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

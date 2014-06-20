/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

import com.google.gson.JsonElement;

import ru.subscribe.pro.api.dto.ApiError;

/**
 * Unauthorized exception.
 *
 * @author Yuri Rychkov
 */
public class UnauthorizedException extends BaseApiErrorException {
    private JsonElement details;

    /**
     * Constructor.
     *
     * @param apiError API error
     * @param details details
     */
    public UnauthorizedException(ApiError apiError, JsonElement details) {
        super(apiError);
        this.details = details;
    }

    public JsonElement getDetails() {
        return details;
    }
}

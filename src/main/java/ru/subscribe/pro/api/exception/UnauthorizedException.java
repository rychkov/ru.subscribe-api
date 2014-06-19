/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

import ru.subscribe.pro.api.dto.ApiError;

/**
 * Unauthorized exception.
 *
 * @author Yuri Rychkov
 */
public class UnauthorizedException extends BaseApiErrorException {
    private Object details;

    /**
     * Constructor.
     *
     * @param apiError API error
     * @param details details
     */
    public UnauthorizedException(ApiError apiError, Object details) {
        super(apiError);
        this.details = details;
    }

    public Object getDetails() {
        return details;
    }
}

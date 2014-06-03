/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

/**
 * Unauthorized exception.
 *
 * @author Yuri Rychkov
 */
public class UnauthorizedException extends BaseException {
    private Object details;

    /**
     * Constructor.
     *
     * @param details details
     */
    public UnauthorizedException(Object details) {
        this.details = details;
    }

    public Object getDetails() {
        return details;
    }
}

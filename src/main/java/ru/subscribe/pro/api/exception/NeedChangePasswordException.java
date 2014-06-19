/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

import ru.subscribe.pro.api.dto.ApiError;

/**
 * Need change password.
 *
 * @author Yuri Rychkov
 */
public class NeedChangePasswordException extends BaseApiErrorException {
    /**
     * Constructor.
     *
     * @param apiError API error
     */
    public NeedChangePasswordException(ApiError apiError) {
        super(apiError);
    }
}

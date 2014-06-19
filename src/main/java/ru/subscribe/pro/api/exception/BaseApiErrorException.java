/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

import ru.subscribe.pro.api.dto.ApiError;

/**
 * Base API error exception class.
 *
 * @author Yuri Rychkov
 */
public class BaseApiErrorException extends BaseException {
    private ApiError apiError;

    /**
     * Constructor.
     *
     * @param apiError error
     */
    public BaseApiErrorException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }


}

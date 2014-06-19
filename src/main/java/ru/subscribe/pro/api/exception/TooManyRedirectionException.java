/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.exception;

/**
 * Too many redirection. Throws when session request redirected more than ru.subscribe.pro.api.Session#MAX_REDIRECT_COUNT
 *
 * @author Yuri Rychkov
 * @see ru.subscribe.pro.api.Connection#MAX_REDIRECT_COUNT
 */
public class TooManyRedirectionException extends BaseException {
    private int redirectCount;

    /**
     * Constructor.
     *
     * @param redirectCount redirect count
     */
    public TooManyRedirectionException(int redirectCount) {
        this.redirectCount = redirectCount;
    }

    public int getRedirectCount() {
        return redirectCount;
    }
}

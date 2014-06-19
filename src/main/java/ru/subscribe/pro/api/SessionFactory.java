/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api;

import java.io.IOException;

import org.apache.http.client.HttpClient;

import ru.subscribe.pro.api.exception.BaseException;

/**
 * Session factory.
 *
 * @author Yuri Rychkov
 */
public final class SessionFactory {
    private SessionFactory() {
    }

    /**
     * Creates session.
     *
     * @param cfg config
     * @param httpClient http client
     * @return session
     *
     * @throws java.io.IOException if IO errors occurred
     * @throws BaseException       on API error
     */
    public static Session createSession(Credentials cfg, HttpClient httpClient) throws IOException, BaseException {
        Session session = new Session(httpClient);
        session.login(cfg.getLogin(), cfg.getSubLogin(), cfg.getPassword());
        return session;
    }
}

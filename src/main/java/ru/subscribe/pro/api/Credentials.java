/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */
package ru.subscribe.pro.api;

/**
 * Credentials for Subscribe.ru API calls.
 */
public class Credentials {

    private String login;
    private String subLogin;
    private String password;

    /**
     * Constructor.
     *
     * @param login login
     * @param subLogin sub login
     * @param password password
     */
    public Credentials(String login, String subLogin, String password) {
        this.login = login;
        this.subLogin = subLogin;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getSubLogin() {
        return subLogin;
    }

    public String getPassword() {
        return password;
    }
}

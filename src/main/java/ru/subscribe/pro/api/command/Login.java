/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */
package ru.subscribe.pro.api.command;

import com.google.gson.annotations.SerializedName;

/**
 * Login command.
 *
 * @author Yuri Rychkov
 */
public class Login extends BaseCommand {
    private String login;
    @SerializedName("sublogin")
    private String subLogin;
    @SerializedName("passwd")
    private String password;

    /**
     * Constructor.
     *
     * @param login login
     * @param password password
     */
    public Login(String login, String password) {
        this(login, null, password);
    }

    /**
     * Constructor.
     *
     * @param login login
     * @param subLogin sub login, can be {@code null}
     * @param password password
     */
    public Login(String login, String subLogin, String password) {
        super(Action.LOGIN);
        this.login = login;
        this.subLogin = subLogin;
        this.password = password;
    }
}

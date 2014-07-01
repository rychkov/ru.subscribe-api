/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */
package ru.subscribe.pro.api.command;

/**
 * Parameter names and default values.
 *
 * @author Yuri Rychkov
 */
public enum Const {
    /** Subscribe.ru base API url. */
    BASE_API_URL("", "https://pro.subscribe.ru/api"),
    /** API version. */
    API_VERSION("apiversion", "100"),
    /** JSON. */
    JSON("json", "1"),
    /** Request id. */
    REQUEST_ID("request.id"),
    /** Request. */
    REQUEST("request"),
    /** Session. */
    SESSION("session"),
    /** Redirect part. */
    REDIRECT("REDIRECT"),
    /** Errors. */
    ERRORS("errors"),
    /** Id. */
    ID("id"),
    /** Explain. */
    EXPLAIN("explain"),
    /** List. */
    LIST("list"),
    /** Object. */
    OBJECT("obj"),
    /** Name. */
    NAME("name"),
    /** Group type. */
    GROUP_TYPE("type"),
    /** Address type. */
    ADDRESS_TYPE("addr_type"),
    /** Email. */
    EMAIL("email"),
    /** Syntax. */
    SYNTAX("syntax"),
    /** SMTP. */
    SMTP("smtp"),
    /** Status. */
    STATUS("status"),
    /** Domain. */
    DOMAIN("domain"),
    /** MX. */
    MX("mx"),
    /** IP. */
    IP("ip"),
    /** PTR. */
    PTR("ptr"),
    /** Code. */
    CODE("code"),
    /** DSN. */
    DSN("dsn"),
    /** Message. */
    MESSAGE("message"),
    /** Newbie. */
    NEWBIE("newbie"),
    /** System. */
    SYSTEM("system"),
    /** Action. */
    ACTION("action"),
    /** Subject. */
    SUBJECT("subject"),
    /** From name. */
    FROM_NAME("from.name"),
    /** From email. */
    FROM_EMAIL("from.email"),
    /** Replay email. */
    REPLAY_EMAIL("reply.email"),
    /** Replay name. */
    REPLAY_NAME("reply.name"),
    /** To name. */
    TO_NAME("to.name"),
    /** Group. */
    GROUP("group"),
    /** Format. */
    FORMAT("format"),
    /** Template. */
    TEMPLATE("template"),
    /** Division. */
    DIVISION("division"),
    /** From. */
    FROM("from"),
    /** Sender. */
    SENDER("sender"),
    /** Text. */
    TEXT("text"),
    /** Template thumbnail. */
    TEMPLATE_THUMBNAIL("template.thumbnail");

    private final String paramName;
    private final String defaultValue;

    private Const(String paramName) {
        this(paramName, null);
    }

    private Const(String paramName, String defaultValue) {
        this.paramName = paramName;
        this.defaultValue = defaultValue;
    }

    public String getParamName() {
        return paramName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}

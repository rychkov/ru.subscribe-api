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
    ADDRESS_TYPE("addr_type");

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

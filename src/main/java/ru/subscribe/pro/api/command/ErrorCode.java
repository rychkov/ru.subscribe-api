/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Error codes.
 *
 * @author Yuri Rychkov
 */
public enum ErrorCode {
    /** Auth failed. */
    AUTH_FAILED("error/auth/failed"),
    /** Wrong cookie. Not needed confirmation.*/
    WRONG_COOKIE("error/member/wrongcookie");


    private final String id;

    /**
     * Constructor.
     *
     * @param id error id
     */
    private ErrorCode(String id) {
        this.id = id;
    }

    /**
     * Resolve error by id.
     *
     * @param id error id
     * @return error
     */
    public static ErrorCode resolveById(String id) {
        if (id == null) {
            throw new NullPointerException("id is null");
        }
        for (ErrorCode error : ErrorCode.values()) {
            if (error.getId().equals(id)) {
                return error;
            }
        }
        throw new IllegalArgumentException("unknown id: " + id);
    }

    public String getId() {
        return id;
    }
}

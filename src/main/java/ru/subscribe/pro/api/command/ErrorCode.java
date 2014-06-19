/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Error codes.
 *
 * @author Yuri Rychkov
 */
public enum ErrorCode {
    /** Unknown error. */
    UNKNONW(""),
    /** Auth failed. */
    AUTH_FAILED("error/auth/failed"),
    /** Wrong cookie. Not needed confirmation.*/
    WRONG_COOKIE("error/member/wrongcookie"),
    /** Group not exist. */
    GROUP_NOT_EXIST("group_id_not_exists"),
    /** Wrong group id. */
    WRONG_GROUP_ID("wrong_group_id"),
    /** Empty name.*/
    ERROR_PROFILE_EMPTYNAME("error/profile/emptyname");

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCode.class);
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
        LOGGER.warn("unknown id: {}", id);
        return UNKNONW;
    }

    public String getId() {
        return id;
    }
}

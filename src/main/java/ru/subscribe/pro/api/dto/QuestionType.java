/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Question type.
 *
 * @author Yuri Rychkov
 */
public enum QuestionType {
    /** Free type AKA text. */
    FREE("free"),
    /** Date time parameter. */
    DATE_TIME("dt"),
    /** One to many relation. */
    ONE_TO_MANY("1m"),
    /** Many to many relation. */
    MANY_TO_MANY("nm"),
    /** Integer number. */
    INTEGER("int");

    private final String value;

    /**
     * Constructor.
     *
     * @param value value
     */
    private QuestionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

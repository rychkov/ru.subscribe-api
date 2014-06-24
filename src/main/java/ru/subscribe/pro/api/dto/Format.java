/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Format.
 *
 * @author Yuri Rychkov
 */
public enum Format {
    /** Email both html and text. */
    EMAIL("email"),
    /** SMS. */
    SMS("sms"),
    /** HTML. */
    HTML("html"),
    /** Text. */
    TEXT("text");

    private final String value;

    private Format(String value) {
        this.value = value;
    }

    /**
     * Resolve format by value.
     *
     * @param value value
     * @return format
     * @throws NullPointerException if value is {@code null}
     * @throws IllegalArgumentException for unknown values
     */
    public static Format resolveByValue(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }

        for (Format type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    public String getValue() {
        return value;
    }
}

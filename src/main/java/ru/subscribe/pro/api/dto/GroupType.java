/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Group type.
 *
 * @author Yuri Rychkov
 */
public enum GroupType {
    /** List. */
    LIST("list"),
    /** Filter based group. */
    FILTER("filter");

    private final String value;

    private GroupType(String value) {
        this.value = value;
    }

    /**
     * Resolve group type by value.
     *
     * @param value value
     * @return group type
     * @throws java.lang.NullPointerException if value is {@code null}
     * @throws java.lang.IllegalArgumentException for unknown values
     */
    public static GroupType resolveByValue(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }

        for (GroupType type : values()) {
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

/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Remote file system domain.
 *
 * @author Yuri Rychkov
 */
public enum RfsDomain {
    /** Image. */
    IMAGE("image"),
    /** Report. */
    REPORT("report");

    private final String value;

    private RfsDomain(String value) {
        this.value = value;
    }

    /**
     * Resolve domain type by value.
     *
     * @param value value
     * @return address type
     * @throws NullPointerException if value is {@code null}
     * @throws IllegalArgumentException for unknown values
     */
    public static RfsDomain resolveByValue(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }

        for (RfsDomain type : values()) {
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

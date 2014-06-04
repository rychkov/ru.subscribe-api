/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Address type.
 *
 * @author Yuri Rychkov
 */
public enum AddressType {
    /** Email. */
    EMAIL("email"),
    /** MSISDN AKA Mobile Subscriber Integrated Services Digital Number. */
    MSISDN("msisdn");

    private final String value;

    private AddressType(String value) {
        this.value = value;
    }

    /**
     * Resolve address type by value.
     *
     * @param value value
     * @return address type
     * @throws java.lang.NullPointerException if value is {@code null}
     * @throws java.lang.IllegalArgumentException for unknown values
     */
    public static AddressType resolveByValue(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }

        for (AddressType type : values()) {
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

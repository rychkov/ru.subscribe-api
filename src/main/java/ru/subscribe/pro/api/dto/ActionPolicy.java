/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

/**
 * Action policy.
 *
 * @author Yuri Rychkov
 */
public enum ActionPolicy {
    /** Error. */
    ERROR("error"),
    /** Update. */
    UPDATE("update"),
    /** Overwrite. */
    OVERWRITE("overwrite");

    private final String value;

    private ActionPolicy(String value) {
        this.value = value;
    }

    /**
     * Resolve policy by value.
     *
     * @param value value
     * @return action policy
     * @throws NullPointerException if value is {@code null}
     * @throws IllegalArgumentException for unknown values
     */
    public static ActionPolicy resolveByValue(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }

        for (ActionPolicy policy : values()) {
            if (policy.value.equalsIgnoreCase(value)) {
                return policy;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    public String getValue() {
        return value;
    }
}

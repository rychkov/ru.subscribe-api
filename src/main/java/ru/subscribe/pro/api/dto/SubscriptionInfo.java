/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Yuri Rychkov
 */
public class SubscriptionInfo {
    private String id;
    private String name;
    private boolean system;

    /**
     * Constructor.
     *
     * @param id id
     * @param name name
     * @param system system flag
     */
    public SubscriptionInfo(String id, String name, Boolean system) {
        this.id = id;
        this.name = name;
        this.system = system;
    }

    public boolean isSystem() {
        return system;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

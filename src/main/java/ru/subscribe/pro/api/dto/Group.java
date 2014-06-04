/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Group info.
 *
 * @author Yuri Rychkov
 */
public class Group {
    private String id;
    private String name;
    private GroupType type;
    private AddressType addressType;

    /**
     * Constructor.
     *
     * @param id group id
     * @param name group name
     * @param type group type
     * @param addressType address type
     */
    public Group(String id, String name, GroupType type, AddressType addressType) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.addressType = addressType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GroupType getType() {
        return type;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

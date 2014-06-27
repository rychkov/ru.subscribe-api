/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Issue draft info.
 *
 * @author Yuri Rychkov
 */
public class IssueDraftInfo {
    private String id;
    private String name;
    private boolean template;
    private Format format;

    /**
     * Constructor.
     *
     * @param id draft id
     * @param name name
     * @param template template
     * @param format format
     */
    public IssueDraftInfo(String id, String name, boolean template, Format format) {
        this.id = id;
        this.name = name;
        this.template = template;
        this.format = format;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isTemplate() {
        return template;
    }

    public Format getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

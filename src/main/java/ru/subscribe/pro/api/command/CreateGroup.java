/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import com.google.gson.annotations.SerializedName;

import ru.subscribe.pro.api.dto.AddressType;
import ru.subscribe.pro.api.dto.Group;
import ru.subscribe.pro.api.dto.GroupType;

/**
 * Create group.
 *
 * @author Yuri Rychkov
 */
public class CreateGroup extends SessionCommand {
    private String id;
    private String name;
    private GroupType type;
    @SerializedName("addr_type")
    private AddressType addressType;
    @SerializedName("issue.passwd")
    private String issuePassword;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param group group
     */
    public CreateGroup(String sessionId, Group group) {
        this(sessionId, group, null);
    }

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param group group
     * @param issuePassword issue password
     */
    public CreateGroup(String sessionId, Group group, String issuePassword) {
        super(Action.GROUP_CREATE, sessionId);
        id = group.getId();
        name = group.getName();
        type = group.getType();
        addressType = group.getAddressType();
        this.issuePassword = issuePassword;
    }
}

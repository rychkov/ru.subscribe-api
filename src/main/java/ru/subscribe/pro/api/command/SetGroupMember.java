/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import ru.subscribe.pro.api.dto.ActionPolicy;
import ru.subscribe.pro.api.dto.AddressType;

/**
 * Set group member.
 *
 * @author Yuri Rychkov
 */
public class SetGroupMember extends SessionCommand {
    @SerializedName("email")
    private String address;
    @SerializedName("addr_type")
    private AddressType addressType;
    @SerializedName("source")
    private String sourceIp;
    @SerializedName("if_exists")
    private ActionPolicy existsPolicy;
    @SerializedName("obj")
    private Map<String, Object> objectMap = new HashMap<>();

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param address address (email or phone)
     * @param type address type
     * @param existsPolicy exists policy
     * @param includeGroupIdList add to groups with this ids
     * @param excludeGroupIdList del from groups with this ids
     * @param ip source ip
     */
    public SetGroupMember(String sessionId, String address, AddressType type, ActionPolicy existsPolicy,
                          List<String> includeGroupIdList, List<String> excludeGroupIdList, String ip) {
        super(Action.MEMBER_SET, sessionId);
        this.address = address;
        addressType = type;
        this.existsPolicy = existsPolicy;
        Map<String, String> map = getGroupMap(includeGroupIdList, true);
        map.putAll(getGroupMap(excludeGroupIdList, false));
        objectMap.put("-group", map);
        sourceIp = ip;
    }

    private Map<String, String> getGroupMap(List<String> groupIdList, boolean include) {
        Map<String, String> map = new HashMap<>();
        if (groupIdList != null && !groupIdList.isEmpty()) {
            for (String id : groupIdList) {
                map.put(id, include ? "1" : "0");
            }
        }
        return map;
    }
}

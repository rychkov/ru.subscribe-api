/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import ru.subscribe.pro.api.dto.RfsDomain;

/**
 * Get remote file system list.
 *
 * @author Yuri Rychkov
 */
public class GetRfsList extends SessionCommand {
    private RfsDomain domain;
    private String path;

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param domain domain
     * @param path path
     */
    public GetRfsList(String sessionId, RfsDomain domain, String path) {
        super(Action.RFS_LIST, sessionId);
        this.domain = domain;
        this.path = path;
    }
}

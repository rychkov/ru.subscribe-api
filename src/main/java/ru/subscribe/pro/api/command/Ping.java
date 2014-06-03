/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */
package ru.subscribe.pro.api.command;

/**
 * Unauthorized ping.
 *
 * @author Yuri Rychkov
 */
public class Ping extends BaseCommand {
    /**
     * Constructor.
     */
    public Ping() {
        super(Action.PING);
    }
}

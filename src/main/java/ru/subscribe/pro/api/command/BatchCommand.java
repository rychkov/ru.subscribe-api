/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.annotations.SerializedName;

/**
 * Batch command.
 *
 * @author Yuri Rychkov
 */
public class BatchCommand extends SessionCommand {
    @SerializedName("stop_on_error")
    private int stopOnError;
    @SerializedName("do")
    private ArrayList<SessionCommand> commandList = new ArrayList<>();


    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    public BatchCommand(String sessionId) {
        this(sessionId, 0);
    }

    /**
     * Constructor.
     *
     * @param sessionId session id
     * @param size batch size
     */
    public BatchCommand(String sessionId, int size) {
        super(Action.BATCH, sessionId);
        commandList.ensureCapacity(size);
    }

    /**
     * Add command to batch.
     *
     * @param cmd command
     */
    public void addCommand(SessionCommand cmd) {
        commandList.add(cmd);
    }

    /**
     * Add command collection.
     *
     * @param commands commands
     */
    public void addAll(Collection<SessionCommand> commands) {
        commandList.addAll(commands);
    }

    /**
     * Stop on error.
     *
     * @param stopFlag if {@code true} stop batch on first error, otherwise process all batch
     */
    public void setStopOnError(boolean stopFlag) {
        if (stopFlag) {
            stopOnError = 1;
        } else {
            stopOnError = 0;
        }
    }
}

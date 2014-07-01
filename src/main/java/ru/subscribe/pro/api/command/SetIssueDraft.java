/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import ru.subscribe.pro.api.dto.Format;

/**
 * Set issue draft.
 *
 * @author Yuri Rychkov
 */
public final class SetIssueDraft extends SessionCommand {
    @SerializedName("obj")
    private Map<String, String> param = new HashMap<>();

    /**
     * Constructor.
     *
     * @param sessionId session id
     */
    private SetIssueDraft(String sessionId) {
        super(Action.ISSUE_DRAFT_SET, sessionId);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private String sessionId;
        private Map<String, String> params = new HashMap<>();

        /**
         * Constructor.
         *
         * @param sessionId session id
         */
        public Builder(String sessionId) {
            this.sessionId = sessionId;
        }

        /**
         * Add subject.
         *
         * @param subject subject
         * @return builder
         */
        public Builder addSubject(String subject) {
            return addParam(Const.SUBJECT.getParamName(), subject);
        }

        /**
         * Add draft name.
         *
         * @param name name
         * @return builder
         */
        public Builder addName(String name) {
            return addParam(Const.NAME.getParamName(), name);
        }

        /**
         * Add format.
         *
         * @param format format
         * @return builder
         */
        public Builder addFormat(Format format) {
            if (format == null) {
                throw new NullPointerException("format is null");
            }
            return addParam(Const.FORMAT.getParamName(), format.getValue());
        }

        /**
         * Add division.
         *
         * @param division division
         * @return builder
         */
        public Builder addDivision(String division) {
            return addParam(Const.DIVISION.getParamName(), division);
        }

        /**
         * Add from.
         *
         * @param from from
         * @return builder
         */
        public Builder addFrom(String from) {
            return addParam(Const.FROM.getParamName(), from);
        }

        /**
         * Add sender.
         *
         * @param sender sender
         * @return builder
         */
        public Builder addSender(String sender) {
            return addParam(Const.SENDER.getParamName(), sender);
        }

        /**
         * Add replay email.
         *
         * @param email email
         * @return builder
         */
        public Builder addReplayEmail(String email) {
            return addParam(Const.REPLAY_EMAIL.getParamName(), email);
        }

        /**
         * Add replay name.
         *
         * @param name name
         * @return builder
         */
        public Builder addReplayName(String name) {
            return addParam(Const.REPLAY_NAME.getParamName(), name);
        }

        /**
         * Add to name.
         *
         * @param name name
         * @return builder
         */
        public Builder addToName(String name) {
            return addParam(Const.TO_NAME.getParamName(), name);
        }

        /**
         * Add text.
         *
         * @param text text
         * @return builder
         */
        public Builder addText(String text) {
            return addParam(Const.TEXT.getParamName(), text);
        }

        private Builder addParam(String key, String value) {
            params.put(key, value);
            return this;
        }

        /**
         * Build issue command.
         *
         * @return issue command
         */
        public SetIssueDraft build() {
            SetIssueDraft result = new SetIssueDraft(sessionId);
            result.param.putAll(params);
            return result;
        }
    }
}

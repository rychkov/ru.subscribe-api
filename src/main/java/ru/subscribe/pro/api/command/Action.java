/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.command;

/**
 * Action enumeration.
 *
 * @author Yuri Rychkov
 */
public enum Action {
    LOGIN("login"),
    LOGOUT("logout"),
    PING("ping"),
    PONG("pong"),

    ANKETA_LIST("anketa.list"),
    ANKETA_GET("anketa.get"),
    ANKETA_SET("anketa.set"),
    ANKETA_CREATE("anketa.create"),
    ANKETA_DELETE("anketa.delete"),
    ANKETA_QUEST_ADD("anketa.quest.add"),
    ANKETA_QUEST_SET("anketa.quest.set"),
    ANKETA_QUEST_DELETE("anketa.quest.delete"),
    ANKETA_QUEST_ORDER("anketa.quest.order"),
    ANKETA_QUEST_RESPONSE_DELETE("anketa.quest.response.delete"),
    ANKETA_QUEST_RESPONSE_ORDER("anketa.quest.response.order"),

    TRACK_LIST("track.list"),
    TRACK_GET("track.get"),

    EMAIL_TEST("email.test"),

    MEMBER_GET("member.get"),
    MEMBER_SET("member.set"),
    MEMBER_DELETE("member.delete"),
    MEMBER_WHERE("member.where"),
    MEMBER_LIST("member.list"),
    MEMBER_LIST_COUNT("member.list.count"),
    MEMBER_IMPORT("member.import"),
    MEMBER_IMPORT_PROBE("member.import.probe"),
    MEMBER_SEND_CONFIRM("member.sendconfirm"),
    MEMBER_UPDATE("member.update"),

    DECORATE_SITE_FORM("decor.siteform"),

    RFS_LIST("rfs.list"),
    RFS_FILE_GET("rfs.file.get"),
    RFS_FILE_PUT("rfs.file.put"),
    RFS_FILE_DELETE("rfs.file.delete"),
    RFS_DIR_MAKE("rfs.dir.make"),
    RFS_DIR_DELETE("rfs.dir.delete"),

    GROUP_LIST("group.list"),
    GROUP_CREATE("group.create"),
    GROUP_GET("group.get"),
    GROUP_SET("group.set"),
    GROUP_DELETE("group.delete"),
    GROUP_FILTER_GET("group.filter.get"),
    GROUP_FILTER_SET("group.filter.set"),
    GROUP_SNAPSHOT("group.snapshot"),
    GROUP_CLEAN("group.clean"),

    ISSUE_SEND("issue.send"),
    ISSUE_LATER_LIST("issue.later.list"),
    ISSUE_LATER_GET("issue.later.get"),
    ISSUE_LATER_SEND("issue.later.send"),
    ISSUE_LATER_DELETE("issue.later.delete"),

    FORMAT_LIST("format.list"),
    FORMAT_GET("format.get"),
    FORMAT_SET("format.set"),
    FORMAT_DELETE("format.delete"),

    LINK_LIST("link.list"),
    LINK_GET("link.get"),
    LINK_CREATE("link.create"),
    LINK_SET("link.set"),
    LINK_SET_GROUP("link.set.group"),
    LINK_GROUP_LIST("link.group.list"),
    LINK_GROUP_GET("link.group.get"),
    LINK_GROUP_SET("link.group.set"),
    LINK_GROUP_DELETE("link.group.delete"),

    STOPLIST_GET("stoplist.get"),
    STOPLIST_ADD("stoplist.add"),
    STOPLIST_DELETE("stoplist.delete"),
    STOPLIST_ERASE("stoplist.erase"),

    STAT_ACTIVITY("stat.activity"),
    STAT_ISSUE("stat.issue"),
    STAT_GROUP_PORTRAIT("stat.group.portrait"),
    STAT_GROUP_COMMON("stat.group.common"),
    STAT_UNI("stat.uni"),

    DATAROW_LIST("datarow.list"),
    DATAROW_GET("datarow.get"),
    DATAROW_CREATE("datarow.create"),
    DATAROW_SET("datarow.set"),
    DATAROW_DELETE("datarow.delete"),
    DATAROW_LOAD("datarow.load"),
    DATAROW_CLEAN("datarow.clean"),

    SEQUENCE_LIST("sequence.list"),
    SEQUENCE_CREATE("sequence.create"),
    SEQUENCE_GET("sequence.get"),
    SEQUENCE_SET("sequence.set"),
    SEQUENCE_DELETE("sequence.delete"),
    SEQUENCE_STEPS_GET("sequence.steps.get"),
    SEQUENCE_STEPS_SET("sequence.steps.set"),
    SEQUENCE_STATS("sequence.stats"),
    SEQUENCE_MEMBER_LIST("sequence.member.list"),
    SEQUENCE_MEMBER_START("sequence.member.start"),
    SEQUENCE_MEMBER_PAUSE("sequence.member.pause"),
    SEQUENCE_MEMBER_RESUME("sequence.member.resume"),
    SEQUENCE_MEMBER_STOP("sequence.member.stop"),
    SEQUENCE_MEMBER_MEMBERSHIP("sequence.member.membership"),

    AUTH_EXT_LIST("authext.list"),
    AUTH_EXT_GET("authext.get"),
    AUTH_EXT_СREATE("authext.сreate"),
    AUTH_EXT_SET("authext.set"),
    AUTH_EXT_DELETE("authext.delete"),
    AUTH_EXT_GA_PROPS("authext.ga.props"),

    SYS_DEDMOROZ("sys.dedmoroz"),
    SYS_SETTINGS_GET("sys.settings.get"),
    SYS_SETTINGS_SET("sys.settings.set"),
    SYS_PASSWORD_SET("sys.password.set"),
    SYS_MESSAGE("sys.message"),
    SYS_LOG("sys.log"),

    USER_LIST("user.list"),
    USER_CREATE("user.create"),
    USER_DELETE("user.delete"),
    USER_SET("user.set"),

    RIGHTS_GET("rights.get"),
    RIGHTS_SET("rights.set");

    private final String value;

    private Action(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

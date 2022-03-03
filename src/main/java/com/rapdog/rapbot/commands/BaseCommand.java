package com.rapdog.rapbot.commands;

import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;

import java.util.List;

/**
 * @author rapdog
 * 指令类
 */
public abstract class BaseCommand {

    /**
     * 指令字符
     */
    private String commandString;

    /**
     * 指令描述
     */
    private String commandDesc;

    /**
     * 指令参数
     */
    private List<String> commandArgs;

    /**
     * 指令授权Id列表
     */
    private List<Long> authIds;

    /**
     * 指令绑定的event
     */
    private MiraiGroupMessageEvent event;

    public void doCommand() {
    }

    public boolean checkAuth(){
        return true;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandDesc() {
        return commandDesc;
    }

    public void setCommandDesc(String commandDesc) {
        this.commandDesc = commandDesc;
    }

    public List<String> getCommandArgs() {
        return commandArgs;
    }

    public void setCommandArgs(List<String> commandArgs) {
        this.commandArgs = commandArgs;
    }

    public List<Long> getAuthIds() {
        return authIds;
    }

    public void setAuthIds(List<Long> authIds) {
        this.authIds = authIds;
    }

    public MiraiGroupMessageEvent getEvent() {
        return event;
    }

    public void setEvent(MiraiGroupMessageEvent event) {
        this.event = event;
    }
}

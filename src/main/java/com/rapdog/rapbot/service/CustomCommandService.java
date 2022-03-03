package com.rapdog.rapbot.service;

import com.rapdog.rapbot.bean.bo.CustomCommand;

import java.util.Map;

/**
 * @author rapdog
 */
public interface CustomCommandService {

    /**
     * 绑定自定义命令
     * @param command 命令字符
     * @param reply 回复语
     * @param creator 命令创建者
     * @param groupId 生效群Id
     */
    String bindCustomCommand(String command, String reply, Long creator, Long groupId);

    /**
     * 解绑自定义命令
     * @param command 命令字符
     */
    String unbindCustomCommand(String command);

    /**
     * 返回是否为自定义命令
     * @param command 命令字符
     * @return boolean
     */
    boolean isCustomCommand(String command);

    /**
     * 返回所有指令-回复的映射map
     * @return Map<String, CustomCommand>
     */
    Map<String, CustomCommand> getAllCustomCommandMap();

    /**
     * 返回指令回复语
     * @param command 指令
     * @return String
     */
    String getCustomCommandReply(String command);
}

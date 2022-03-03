package com.rapdog.rapbot.utils;

import cn.hutool.core.map.MapUtil;
import com.rapdog.rapbot.bean.bo.CustomCommand;
import com.rapdog.rapbot.commands.BaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.service.CustomCommandService;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rapdog
 */
public class CommandUtils {

    public static Map<String, CustomCommand> customCommandMap = new HashMap<>(64);

    public static void initCustomCommandMap(){
        CustomCommandService customCommandService = SpringUtil.getBean(CustomCommandService.class);
        customCommandMap = customCommandService.getAllCustomCommandMap();
    }

    public static boolean isCommandTrue(MessageChain nativeMessageChain){
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        String commandValue = commandStr.length > 1 ? commandStr[1] : null;

        return CommandConstants.TRUE.equalsIgnoreCase(commandValue) || CommandConstants.T.equalsIgnoreCase(commandValue);
    }

    public static boolean isCommandTrue(BaseCommand baseCommand){
        List<String> commandArgs = baseCommand.getCommandArgs();
        String commandValue = commandArgs.isEmpty() ? null : commandArgs.get(0);
        return CommandConstants.TRUE.equalsIgnoreCase(commandValue) || CommandConstants.T.equalsIgnoreCase(commandValue);
    }

    public static boolean isCommandFalse(MessageChain nativeMessageChain){
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        String commandValue = commandStr.length > 1 ? commandStr[1] : null;

        return CommandConstants.FALSE.equalsIgnoreCase(commandValue) || CommandConstants.F.equalsIgnoreCase(commandValue);
    }

    public static boolean isCommandFalse(BaseCommand baseCommand){
        List<String> commandArgs = baseCommand.getCommandArgs();
        String commandValue = commandArgs.isEmpty() ? null : commandArgs.get(0);
        return CommandConstants.FALSE.equalsIgnoreCase(commandValue) || CommandConstants.F.equalsIgnoreCase(commandValue);
    }

    public static boolean isCommand(MessageChain nativeMessageChain){
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        String command = commandStr[0];
        return Arrays.asList(CommandConstants.ALL_COMMAND).contains(command);
    }

    /**
     * 判断消息是否为自定义指令且在当前群组激活
     * @param nativeMessageChain 消息
     * @param groupId 当前群id
     * @return boolean
     */
    public static boolean isActiveGroupCustomCommand(MessageChain nativeMessageChain, Long groupId){
        if (MapUtil.isEmpty(customCommandMap)){
            initCustomCommandMap();
        }
        String command = nativeMessageChain.contentToString();
        return customCommandMap.containsKey(command) && isGroupCustomCommandActive(customCommandMap.get(command),groupId);
    }

    public static boolean isGroupCustomCommandActive(CustomCommand command, Long groupId){
        // 若命令的激活群号列表为空，则全局开启
        return command.getActiveGroups().isEmpty() || command.getActiveGroups().contains(groupId);
    }

    public static boolean isCommandOrActiveGroupCustomCommand(MessageChain nativeMessageChain, Long groupId){
        return isCommand(nativeMessageChain) || isActiveGroupCustomCommand(nativeMessageChain, groupId);
    }

    public static String getCustomCommandReply(String customCommandStr){
        if (MapUtil.isEmpty(customCommandMap)){
            initCustomCommandMap();
        }
        return customCommandMap.get(customCommandStr).getReplyStr();
    }
}
package com.rapdog.rapbot.commands;

import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.api.ts3query.TsClientInfoQuery;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * ts相关指令
 * @author rapdog
 */
public class TsCommand extends BaseCommand {

    private static final Logger logger = LoggerFactory.getLogger(TsCommand.class);

    public TsCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.TS);
        this.setCommandDesc("TS在线查询");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);
    }

    @Override
    public void doCommand() {
        logger.info("start client info query");
        this.getEvent().sendBlocking(TsClientInfoQuery.getClients());
        logger.info("end client info query");
    }
}

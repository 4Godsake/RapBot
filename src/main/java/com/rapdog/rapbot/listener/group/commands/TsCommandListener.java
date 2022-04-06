package com.rapdog.rapbot.listener.group.commands;

import com.rapdog.rapbot.commands.TsCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
 * ts指令监听器
 * @author rapdog
 */
@Component
public class TsCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(TsCommandListener.class);

    @Filter(value = CommandConstants.TS, matchType = MatchType.TEXT_EQUALS_IGNORE_CASE)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/ts指令，开始处理...");
        TsCommand tsCommand = new TsCommand(event);
        if (tsCommand.checkAuth()){
            tsCommand.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("/ts指令，处理完成...");
    }
}

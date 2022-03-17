package com.rapdog.rapbot.listener.group.commands;

import com.rapdog.rapbot.commands.TodayHistoryCommand;
import com.rapdog.rapbot.commands.TsCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Filters;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
 * 复读指令监听器
 * @author rapdog
 */
@Component
public class TodayHistoryCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(TodayHistoryCommandListener.class);

    @Filter(value = CommandConstants.TODAY_HISTORY, matchType = MatchType.TEXT_EQUALS_IGNORE_CASE,
            or = @Filters(value = {@Filter(value = CommandConstants.TODAY_HISTORY_CHINESE, matchType = MatchType.TEXT_EQUALS)}))
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/todayHistory指令，开始处理...");
        TodayHistoryCommand command = new TodayHistoryCommand(event);
        if (command.checkAuth()){
            command.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("历史上的今天指令，处理完成...");
    }
}

package com.rapdog.rapbot.listener.group.commands;

import com.rapdog.rapbot.commands.RepeatBaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import love.forte.simboot.annotation.Filter;
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
public class RepeatCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(RepeatCommandListener.class);

    @Filter(value = CommandConstants.REPEAT, matchType = MatchType.TEXT_STARTS_WITH)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/repeat指令，开始处理...");
        RepeatBaseCommand repeatCommand = new RepeatBaseCommand(event);
        if (repeatCommand.checkAuth()){
            repeatCommand.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("/repeat指令处理完成...");
    }
}

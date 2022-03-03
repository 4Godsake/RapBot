package com.rapdog.rapbot.listener.group.commands;

import com.rapdog.rapbot.commands.ReplyBaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
 * 自定义回复指令监听器
 * @author rapdog
 */
@Component
public class ReplyCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(ReplyCommandListener.class);

    @Filter(value = CommandConstants.REPLY, matchType = MatchType.TEXT_STARTS_WITH)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/reply指令，开始处理...");
        ReplyBaseCommand replyCommand = new ReplyBaseCommand(event);
        if (replyCommand.checkAuth()){
            replyCommand.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("/reply指令，处理完成...");
    }
}

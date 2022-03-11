package com.rapdog.rapbot.listener.group.commands;

import com.rapdog.rapbot.commands.CovCommand;
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
public class CovCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(CovCommandListener.class);

    @Filter(value = CommandConstants.COV, matchType = MatchType.TEXT_STARTS_WITH)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/cov指令，开始处理...");
        CovCommand covCommand = new CovCommand(event);
        if (covCommand.checkAuth()){
            covCommand.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("/cov指令，处理完成...");
    }
}

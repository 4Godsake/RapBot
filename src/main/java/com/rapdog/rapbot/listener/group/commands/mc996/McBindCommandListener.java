package com.rapdog.rapbot.listener.group.commands.mc996;

import com.rapdog.rapbot.commands.mc996.McBindCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.exception.InvalidParamException;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
 * mcbind监听器
 * @author rapdog
 */
@Component
public class McBindCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(McBindCommandListener.class);

    @Filter(value = CommandConstants.MC_BIND, matchType = MatchType.TEXT_STARTS_WITH)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        try{
            logger.info("收到/mcbind指令，开始处理...");
            McBindCommand mcBindCommand = new McBindCommand(event);
            mcBindCommand.doCommand();
            logger.info("/mcbind指令，处理完成...");
        }catch (InvalidParamException e){
            event.sendBlocking(e.getMessage());
        }

    }
}

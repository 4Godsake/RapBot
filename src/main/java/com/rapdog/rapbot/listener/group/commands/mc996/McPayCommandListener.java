package com.rapdog.rapbot.listener.group.commands.mc996;

import com.rapdog.rapbot.commands.mc996.McBindCommand;
import com.rapdog.rapbot.commands.mc996.McPayCommand;
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
public class McPayCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(McPayCommandListener.class);

    @Filter(value = CommandConstants.MC_PAY, matchType = MatchType.TEXT_STARTS_WITH)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        try{
            logger.info("收到/pay指令，开始处理...");
            McPayCommand mcPayCommand = new McPayCommand(event);
            mcPayCommand.doCommand();
            logger.info("/pay指令，处理完成...");
        }catch (Exception e){
            event.sendBlocking(e.getMessage());
        }

    }
}

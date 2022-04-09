package com.rapdog.rapbot.listener.group.commands.mc996;

import com.rapdog.rapbot.commands.mc996.McBuyCommand;
import com.rapdog.rapbot.commands.mc996.McPayCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
 * mcbuy监听器
 * @author rapdog
 */
@Component
public class McBuyCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(McBuyCommandListener.class);

    @Filter(value = CommandConstants.MC_BUY, matchType = MatchType.TEXT_STARTS_WITH)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        try{
            logger.info("收到/buy指令，开始处理...");
            McBuyCommand mcBuyCommand = new McBuyCommand(event);
            mcBuyCommand.doCommand();
            logger.info("/buy指令，处理完成...");
        }catch (Exception e){
            event.sendBlocking(e.getMessage());
        }

    }
}

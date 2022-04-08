package com.rapdog.rapbot.listener.group.commands.mc996;

import com.rapdog.rapbot.commands.mc996.McBindCommand;
import com.rapdog.rapbot.commands.mc996.McMyInfoCommand;
import com.rapdog.rapbot.constants.CommandConstants;
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
public class McMyInfoCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(McMyInfoCommandListener.class);

    @Filter(value = CommandConstants.MC_MY_INFO_CHINESE, matchType = MatchType.TEXT_EQUALS_IGNORE_CASE)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        if (event.getGroup().getId().getValue().equals(904238330L)){
            logger.info("收到我的信息指令，开始处理...");
            McMyInfoCommand mcMyInfoCommand = new McMyInfoCommand(event);
            if (mcMyInfoCommand.checkAuth()){
                mcMyInfoCommand.doCommand();
            }else {
                event.sendBlocking("权限验证失败");
            }
            logger.info("/我的信息指令，处理完成...");
        }
    }
}

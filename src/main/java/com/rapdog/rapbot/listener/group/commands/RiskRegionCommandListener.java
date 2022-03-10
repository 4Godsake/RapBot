package com.rapdog.rapbot.listener.group.commands;

import com.rapdog.rapbot.commands.RiskRegionCommand;
import com.rapdog.rapbot.commands.WeatherCommand;
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
public class RiskRegionCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(RiskRegionCommandListener.class);

    @Filter(value = CommandConstants.RISK_REGION, matchType = MatchType.TEXT_EQUALS_IGNORE_CASE,
            or = @Filters(value = {@Filter(value = CommandConstants.RISK_REGION_CHINESE_1, matchType = MatchType.TEXT_ENDS_WITH),
                    @Filter(value = CommandConstants.RISK_REGION_CHINESE_2, matchType = MatchType.TEXT_EQUALS)}))
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/riskRegion指令，开始处理...");
        RiskRegionCommand riskRegionCommand = new RiskRegionCommand(event);
        if (riskRegionCommand.checkAuth()){
            riskRegionCommand.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("/riskRegion指令，处理完成...");
    }
}

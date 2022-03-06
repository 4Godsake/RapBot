package com.rapdog.rapbot.listener.group.commands;

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
public class WeatherCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(WeatherCommandListener.class);

    @Filter(value = CommandConstants.WEATHER, matchType = MatchType.TEXT_STARTS_WITH,
            or = @Filters(value = {@Filter(value = CommandConstants.WEATHER_CHINESE, matchType = MatchType.TEXT_STARTS_WITH),
                    @Filter(value = CommandConstants.WEATHER_CHINESE, matchType = MatchType.TEXT_ENDS_WITH)}))
    @Listener
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("收到/weather指令，开始处理...");
        WeatherCommand tsCommand = new WeatherCommand(event);
        if (tsCommand.checkAuth()){
            tsCommand.doCommand();
        }else {
            event.sendBlocking("无权限");
        }
        logger.info("/weather指令，处理完成...");
    }
}

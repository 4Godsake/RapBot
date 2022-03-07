package com.rapdog.rapbot.commands;

import cn.hutool.http.HttpUtil;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.ts3query.TsClientInfoQuery;
import com.rapdog.rapbot.utils.WeatherApi;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 天气查询指令
 * @author rapdog
 */
public class WeatherCommand extends BaseCommand {

    private static final Logger logger = LoggerFactory.getLogger(WeatherCommand.class);

    public WeatherCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.WEATHER);
        this.setCommandDesc("天气查询");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String commandStr = nativeMessageChain.contentToString();
        String[] commandStrs = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = new ArrayList<>();
        if (commandStr.contains(CommandConstants.WEATHER_CHINESE)){
            commandArgs.add(commandStr.replace(" ","").replace(CommandConstants.WEATHER_CHINESE,""));
        }else{
            commandArgs = Arrays.asList(commandStrs).subList(1,commandStrs.length);
        }
        this.setCommandArgs(commandArgs);
    }

    @Override
    public void doCommand() {
        logger.info("sending weather info");
        this.getEvent().sendBlocking(WeatherApi.getWeather(this.getCommandArgs().get(0)));
    }


}

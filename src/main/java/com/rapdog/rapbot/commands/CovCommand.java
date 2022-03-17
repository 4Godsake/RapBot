package com.rapdog.rapbot.commands;

import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.api.COVID19Api;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 天气查询指令
 * @author rapdog
 */
public class CovCommand extends BaseCommand {

    private static final Logger logger = LoggerFactory.getLogger(CovCommand.class);

    public CovCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.COV);
        this.setCommandDesc("疫情查询");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStrs = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStrs).subList(1,commandStrs.length);
        this.setCommandArgs(commandArgs);
    }

    @Override
    public void doCommand() {
        logger.info("sending cov info");
        if (this.getCommandArgs().isEmpty()){
            this.getEvent().sendBlocking(COVID19Api.getCovChinaOverview());
        }else {
            if ("now".equals(this.getCommandArgs().get(0))){
                this.getEvent().sendBlocking(COVID19Api.getCovData().getCovNowAllTreeData());
            }else if ("add".equals(this.getCommandArgs().get(0))){
                this.getEvent().sendBlocking(COVID19Api.getCovData().getCovAddAllTreeData());
            }
        }

    }


}

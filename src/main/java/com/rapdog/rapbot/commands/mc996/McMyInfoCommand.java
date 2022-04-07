package com.rapdog.rapbot.commands.mc996;

import cn.hutool.core.util.StrUtil;
import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.BaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.service.McUserService;
import com.rapdog.rapbot.utils.SpringUtil;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rapdog
 */
public class McMyInfoCommand extends BaseCommand {

    public McMyInfoCommand(){}

    /**
     * /bindMC
     * @param event
     */
    public McMyInfoCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_MY_INFO);
        this.setCommandDesc("mc用户信息查询");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);

    }

    @Override
    public void doCommand(){
        int userQid = this.getEvent().getAuthor().getId().getValue().intValue();
        McUserService mcUserService = SpringUtil.getBean(McUserService.class);
        // 绑定mcId
        McUser user = mcUserService.getUserByQid(userQid);
        this.getEvent().sendBlocking(user != null ? user.toString() : "未查询到用户信息");
    }

}

package com.rapdog.rapbot.commands;

import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.utils.CommandUtils;
import com.rapdog.rapbot.utils.RepeatActiveGroupUtils;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rapdog
 */
public class RepeatBaseCommand extends BaseCommand {

    public RepeatBaseCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.REPEAT);
        this.setCommandDesc("复读开关");
        // 写死的指令权限列表
        List<Long> authIdsList = new ArrayList<>();
        authIdsList.add(1025744898L);
        this.setAuthIds(authIdsList);
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);

    }

    @Override
    public void doCommand(){
        Long groupId = this.getEvent().getGroup().getId().getValue();
        // 开始复读
        if (CommandUtils.isCommandTrue(this)){
            RepeatActiveGroupUtils.addGroup(groupId);
            this.getEvent().sendBlocking("复读模式已开启");
        }else if (CommandUtils.isCommandFalse(this)){
            RepeatActiveGroupUtils.removeGroup(groupId);
            this.getEvent().sendBlocking("复读模式已关闭");
        }
    }

    @Override
    public boolean checkAuth(){
        Long senderId = this.getEvent().getAuthor().getId().getValue();
        return this.getAuthIds().contains(senderId);
    }
}

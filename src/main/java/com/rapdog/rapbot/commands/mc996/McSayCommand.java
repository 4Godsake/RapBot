package com.rapdog.rapbot.commands.mc996;

import cn.hutool.core.util.StrUtil;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.BaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.exception.InvalidParamException;
import com.rapdog.rapbot.service.McUserService;
import com.rapdog.rapbot.utils.KafkaUtils;
import com.rapdog.rapbot.utils.SpringUtil;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 发送指令
 * @author rapdog
 */
public class McSayCommand extends BaseCommand {

    public McSayCommand(){}

    /**
     * /say
     * @param event
     */
    public McSayCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_SAY);
        this.setCommandDesc("发送mc消息指令");
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
        try{
            StringBuilder mcMsgBuilder = new StringBuilder();
            for (String arg : this.getCommandArgs()) {
                mcMsgBuilder.append(arg).append(" ");
            }
            String mcMsg = mcMsgBuilder.toString().trim();
            // 将消息提交到kafka
            KafkaUtils.send(KafkaUtils.getProducer(), "TestTopic", mcMsg);
            this.getEvent().sendBlocking("命令已提交");
        }catch (Exception e){
            e.printStackTrace();
            this.getEvent().sendBlocking(e.getMessage());
        }

    }

    @Override
    public boolean checkAuth(){
        Long senderId = this.getEvent().getAuthor().getId().getValue();
        return this.getAuthIds().contains(senderId);
    }
}

package com.rapdog.rapbot.commands.mc996;

import cn.hutool.core.util.StrUtil;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.BaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.exception.InvalidParamException;
import com.rapdog.rapbot.service.McUserService;
import com.rapdog.rapbot.utils.SpringUtil;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import love.forte.simbot.definition.User;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rapdog
 */
public class McPayCommand extends BaseCommand {

    public McPayCommand(){}

    /**
     * /pay @
     * @param event
     */
    public McPayCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_BIND);
        this.setCommandDesc("支付指令");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);

    }

    @Override
    public void doCommand() throws InvalidParamException,NumberFormatException{
        int userQid = this.getEvent().getAuthor().getId().getValue().intValue();
        if (this.getCommandArgs().size() != 2){
            throw new InvalidParamException("入参有误，请参考/pay @xxx money");
        }
        long targetQid = Long.parseLong(this.getCommandArgs().get(0).replace("@",""));
        float amount = Float.parseFloat(this.getCommandArgs().get(1));
        McUserService mcUserService = SpringUtil.getBean(McUserService.class);
        ResultVO result = mcUserService.pay(userQid,targetQid,amount);
        this.getEvent().sendBlocking(result.getMessage());
    }

    @Override
    public boolean checkAuth(){
        Long senderId = this.getEvent().getAuthor().getId().getValue();
        return this.getAuthIds().contains(senderId);
    }
}

package com.rapdog.rapbot.commands.mc996;

import cn.hutool.core.util.StrUtil;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.BaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.exception.InvalidParamException;
import com.rapdog.rapbot.service.McGoodsService;
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
public class McBuyCommand extends BaseCommand {

    public McBuyCommand(){}

    /**
     * /buy
     * @param event
     */
    public McBuyCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_BIND);
        this.setCommandDesc("购买商品 示例：/buy [商品id] [数量]");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);

    }

    @Override
    public void doCommand() throws InvalidParamException{
        long userQid = this.getEvent().getAuthor().getId().getValue();
        String goodsIdStr = this.getCommandArgs().isEmpty() ? null :this.getCommandArgs().get(0);
        String numStr = this.getCommandArgs().isEmpty() ? null :this.getCommandArgs().get(1);
        if (StrUtil.isEmpty(goodsIdStr)){
            throw new InvalidParamException("缺少指令参数[商品Id]");
        }
        if (StrUtil.isEmpty(numStr)){
            throw new InvalidParamException("缺少指令参数[购买数量]");
        }
        McGoodsService mcGoodsService = SpringUtil.getBean(McGoodsService.class);
        // 绑定mcId
        ResultVO result = mcGoodsService.bindUser(userQid,mcId);
        this.getEvent().sendBlocking(result.getMessage());
    }

    @Override
    public boolean checkAuth(){
        Long senderId = this.getEvent().getAuthor().getId().getValue();
        return this.getAuthIds().contains(senderId);
    }
}

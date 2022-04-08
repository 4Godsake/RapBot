package com.rapdog.rapbot.commands.mc996;

import cn.hutool.core.util.StrUtil;
import com.rapdog.rapbot.bean.bo.McGoods;
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

import java.util.Arrays;
import java.util.List;

/**
 * @author rapdog
 */
public class McShopCommand extends BaseCommand {

    public McShopCommand(){}

    /**
     * /shop
     * @param event
     */
    public McShopCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_SHOP);
        this.setCommandDesc("获取商品列表");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);

    }

    @Override
    public void doCommand() throws InvalidParamException{
        McGoodsService mcGoodsService = SpringUtil.getBean(McGoodsService.class);
        // 查询商品列表
        List<McGoods> goodsList = mcGoodsService.getGoodsList();
        // 拼接返回信息
        this.getEvent().sendBlocking(getGoodsStr(goodsList));
    }

    private String getGoodsStr(List<McGoods> goodsList){
        StringBuilder sb = new StringBuilder("【商品列表】");
        for (McGoods goods : goodsList) {
            sb.append("\n「商品id」："+ goods.getGoodsId())
                    .append(" 「名称」：").append(goods.getGoodsName())
                    .append(" 「价格」：").append(goods.getGoodsPrice()).append("狗币")
                    .append("「库存」:").append(goods.getGoodsInventory());
        }
        return sb.toString();
    }
}


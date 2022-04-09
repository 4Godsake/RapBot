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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rapdog
 */
public class McBuyCommand extends BaseCommand {

    private static final Logger logger = LoggerFactory.getLogger(McBuyCommand.class);

    public McBuyCommand(){}

    /**
     * /buy
     * @param event
     */
    public McBuyCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_BUY);
        this.setCommandDesc("购买商品 示例：/buy [商品id] [数量]");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);

    }

    @Override
    public void doCommand() {
        try{
            if (this.getCommandArgs().size() != 2){
                throw new InvalidParamException("指令格式有误，请参考：/buy [商品id] [购买数量]");
            }
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
            ResultVO result = mcGoodsService.buyGoodsById(Integer.parseInt(goodsIdStr),userQid,Integer.parseInt(numStr));
            this.getEvent().sendBlocking(result.getMessage());
        }catch(NumberFormatException nfe){
            this.getEvent().sendBlocking("入参有误，请输入正确的数字！");
        }catch (Exception e){
            logger.error("购买指令异常",e);
            this.getEvent().sendBlocking(e.getMessage());
        }

    }
}

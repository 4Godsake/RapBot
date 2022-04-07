package com.rapdog.rapbot.commands.mc996;

import cn.hutool.core.util.StrUtil;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.BaseCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.service.McUserService;
import com.rapdog.rapbot.service.impl.McUserServiceImpl;
import com.rapdog.rapbot.utils.CommandUtils;
import com.rapdog.rapbot.utils.RepeatActiveGroupUtils;
import com.rapdog.rapbot.utils.SpringUtil;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rapdog
 */
public class McBindCommand extends BaseCommand {

    public McBindCommand(){}

    /**
     * /bindMC
     * @param event
     */
    public McBindCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.MC_BIND);
        this.setCommandDesc("mc用户绑定");
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
        int userQid = this.getEvent().getAuthor().getId().getValue().intValue();
        String mcId = this.getCommandArgs().isEmpty() ? null :this.getCommandArgs().get(0);
        if (StrUtil.isEmpty(mcId)){
            this.getEvent().sendBlocking("缺少指令参数[mcID]");
        }
        McUserService mcUserService = SpringUtil.getBean(McUserService.class);
        // 绑定mcId
        ResultVO result = mcUserService.bindUser(userQid,mcId);
        this.getEvent().sendBlocking(result.getMessage());
    }

    @Override
    public boolean checkAuth(){
        Long senderId = this.getEvent().getAuthor().getId().getValue();
        return this.getAuthIds().contains(senderId);
    }
}

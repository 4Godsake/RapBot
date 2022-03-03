package com.rapdog.rapbot.listener.group;

import com.rapdog.rapbot.service.CustomCommandService;
import com.rapdog.rapbot.utils.CommandUtils;
import love.forte.simboot.annotation.Listener;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 自定义命令监听
 * @author rapdog
 */
@Component
public class CustomCommandListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomCommandListener.class);

    @Autowired
    private CustomCommandService customCommandService;

    @Listener
    //todo 可以尝试使用自定义filter处理类
    public void listen(MiraiGroupMessageEvent event) {
        Long groupId = event.getGroup().getId().toLong();
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        if (CommandUtils.isActiveGroupCustomCommand(nativeMessageChain,groupId)){
            String customCommand = nativeMessageChain.contentToString();
            String reply = CommandUtils.getCustomCommandReply(customCommand);
            logger.info("接收到自定义指令：{}---回复语：{}",customCommand,reply);
            event.sendBlocking(reply);
        }
    }

}

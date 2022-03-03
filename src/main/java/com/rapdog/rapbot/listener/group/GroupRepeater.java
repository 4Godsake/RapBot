package com.rapdog.rapbot.listener.group;

import com.rapdog.rapbot.utils.CommandUtils;
import com.rapdog.rapbot.utils.RepeatActiveGroupUtils;
import love.forte.simboot.annotation.Listener;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
 * @author rapdog
 */
@Component
public class GroupRepeater {

    private static final Logger logger = LoggerFactory.getLogger(GroupRepeater.class);

    @Listener
    public void listen(MiraiGroupMessageEvent event) {

        // 事件发生的群
        Long groupId = event.getGroup().getId().getValue();
        String groupName = event.getGroup().getName();
        String authorName = event.getAuthor().getNickOrUsername();
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        // nativeMessageChain是mirai中的原生事件对象
        // 只有在使用mirai组件下的特殊事件类型的时候才会有
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        /**
         * Messages 则是simbot提供的消息类型，
         * 无论如何都能获取到，只不过可能其中包含了mirai组件下提供的消息类型实现.
         * final Messages messages = messageContent.getMessages();
         */
        // 这里直接展示mirai的原生消息对象
        logger.info("「{}」在「{}」里发送了消息：{}", authorName, groupName, nativeMessageChain);

        logger.info("groupId:{},flag:{}",groupId,RepeatActiveGroupUtils.isGroupToggleOn(groupId));
        if (RepeatActiveGroupUtils.isGroupToggleOn(groupId) && !CommandUtils.isCommandOrActiveGroupCustomCommand(nativeMessageChain, groupId)){
            event.sendBlocking(messageContent);
        }
    }

}

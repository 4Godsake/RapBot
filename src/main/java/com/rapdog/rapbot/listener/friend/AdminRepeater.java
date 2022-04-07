package com.rapdog.rapbot.listener.friend;


import love.forte.simboot.annotation.Listener;
import love.forte.simbot.component.mirai.event.MiraiFriendMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.springframework.stereotype.Component;

@Component
public class AdminRepeater {

    @Listener
    public void listen(MiraiFriendMessageEvent event) {

        // 事件发生的群
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        // nativeMessageChain是mirai中的原生事件对象
        // 只有在使用mirai组件下的特殊事件类型的时候才会有
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        /**
         * Messages 则是simbot提供的消息类型，
         * 无论如何都能获取到，只不过可能其中包含了mirai组件下提供的消息类型实现.
         * final Messages messages = messageContent.getMessages();
         */
        event.sendBlocking(messageContent);
    }

}

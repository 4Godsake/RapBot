//package com.rapdog.rapbot.listener.group;
//
//import com.rapdog.rapbot.bean.vo.AddOneCounter;
//import com.rapdog.rapbot.utils.CommandUtils;
//import com.rapdog.rapbot.utils.RepeatActiveGroupUtils;
//import love.forte.simboot.annotation.Listener;
//import love.forte.simbot.LoggerFactory;
//import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
//import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
//import net.mamoe.mirai.message.data.MessageChain;
//import org.slf4j.Logger;
//import org.springframework.stereotype.Component;
//
//
///**
// * @author rapdog
// * +1复读机
// * 当群中同一条消息连续发三遍时，+1
// */
//@Component
//public class GroupAddOneRepeater {
//
//    private static final Logger logger = LoggerFactory.getLogger(GroupAddOneRepeater.class);
//
//    @Listener
//    public void listen(MiraiGroupMessageEvent event) {
//
//        // 事件发生的群
//        Long groupId = event.getGroup().getId().getValue();
//        MiraiReceivedMessageContent messageContent = event.getMessageContent();
//        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
//        logger.info("【+1】:{}",messageContent.getMessages().toString());
//        if (AddOneCounter.isAddOne(groupId,messageContent.getMessages().toString()) && groupId != 994070653L){
//            logger.info("【+1】:{}",messageContent.getMessages().toString());
//            event.sendBlocking(messageContent);
//        }
//    }
//
//}

package com.rapdog.rapbot.listener.group;

import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.LongID;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * @author rapdog
 * 从其他群复读环球网新闻
 */
@Component
public class GroupNewsRepeater {

    private static final Logger logger = LoggerFactory.getLogger(GroupNewsRepeater.class);

    @Filter(value = "【环球网】", matchType = MatchType.TEXT_CONTAINS)
    @Listener
    public void listen(MiraiGroupMessageEvent event) {

        // 事件发生的群
        Long groupId = event.getGroup().getId().getValue();
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        logger.info("groupId:{}",groupId);
        if (1043409458L == groupId){
            Objects.requireNonNull(event.getBot().getGroup(new LongID(864386252)))
                    .sendBlocking(messageContent);
        }
    }

}

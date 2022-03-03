package com.rapdog.rapbot.listener.group;

import love.forte.simboot.annotation.Listener;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiMemberJoinEvent;
import love.forte.simbot.message.At;
import love.forte.simbot.message.Messages;
import love.forte.simbot.message.Text;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author rapdog
 */
@Component
public class GroupJoinListener {

    private static final Logger logger = LoggerFactory.getLogger(GroupJoinListener.class);

    @Value("${bot.admin}")
    private String adminId;

    @Listener
    public void listen(MiraiMemberJoinEvent event) {

        String userName = event.getMember().getNickOrUsername();
        logger.info("「{}」加入了群「{}」", userName, event.getGroup().getId());
        final Messages message = Messages.getMessages(
                Text.of("热烈欢迎「"+userName+"」！"),
                new At(event.getMember().getId())
        );
        event.getSource().sendBlocking(message);
    }

}

package com.rapdog.rapbot.listener.group;

import com.rapdog.rapbot.utils.CommandUtils;
import com.rapdog.rapbot.utils.RepeatActiveGroupUtils;
import love.forte.simboot.annotation.Listener;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiBotInvitedJoinGroupRequestEvent;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author rapdog
 */
@Component
public class GroupInviteListener {

    private static final Logger logger = LoggerFactory.getLogger(GroupInviteListener.class);

    @Value("${bot.admin}")
    private String adminId;

    @Listener
    public void listen(MiraiBotInvitedJoinGroupRequestEvent event) {

        // 事件发生的群
        String inviterId = event.getInviter().getId().toString();
        logger.info("「{}」邀请加入群「{}」", inviterId, event.getGroup().getId());
        if (adminId.equals(inviterId)){
            event.acceptAsync();
            logger.info("已接受「{}」的群邀请",inviterId);
        }else {
            logger.info("邀请者「{}」非admin「{}」 已拒绝",inviterId,adminId);
        }
    }

}

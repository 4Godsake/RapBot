package com.rapdog.rapbot.utils;

import love.forte.simbot.BotManager;
import love.forte.simbot.ID;
import love.forte.simbot.LongID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

/**
 * 用于消息发送的工具类
 *
 * @author rapdog
 */
public class MessageSendUtils {

    @Value("${bot.id}")
    private Long botId;

    @Autowired
    private BotManager manager;

    public void sendGroupMessage(String message,Long groupId){
        ID id = new LongID(864812731);
        ID group = new LongID(groupId);
        Objects.requireNonNull(Objects.requireNonNull(manager.get(id)).getGroup(group)).sendBlocking(message);

    }
}

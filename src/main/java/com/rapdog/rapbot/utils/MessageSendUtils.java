package com.rapdog.rapbot.utils;

import kotlin.coroutines.Continuation;
import love.forte.simbot.BotManager;
import love.forte.simbot.ID;
import love.forte.simbot.LongID;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.internal.utils.ExternalResourceImplByFile;
import net.mamoe.mirai.utils.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.Objects;

/**
 * 用于消息发送的工具类
 *
 * @author rapdog
 */
public class MessageSendUtils {

    private static final Logger logger = LoggerFactory.getLogger(MessageSendUtils.class);

    @Value("${bot.id}")
    private Long botId;

    @Autowired
    private BotManager manager;

    public void sendGroupMessage(String message,Long groupId){
        ID id = new LongID(864812731);
        ID group = new LongID(groupId);
        Objects.requireNonNull(Objects.requireNonNull(manager.get(id)).getGroup(group)).sendBlocking(message);

    }

    public static void sendGroupFile(MiraiGroupMessageEvent event, File file){
        final Group originalGroup = event.getGroup().getNativeContact();
        // 直接操作 mirai api. 相关内容需要参考mirai api
        try (ExternalResource resource = ExternalResource.create(file)){
            originalGroup.getFiles().uploadNewFile(file.getName(), resource);
        }catch (Exception e){
            logger.error("发送群文件异常：",e);
        }
    }
}

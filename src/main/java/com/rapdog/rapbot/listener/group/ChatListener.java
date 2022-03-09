package com.rapdog.rapbot.listener.group;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.rapdog.rapbot.commands.CovCommand;
import com.rapdog.rapbot.constants.CommandConstants;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * 复读指令监听器
 * @author rapdog
 */
@Component
public class ChatListener {

    private static final Logger logger = LoggerFactory.getLogger(ChatListener.class);

    @Listener
    public void listen(MiraiGroupMessageEvent event) {

        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        if (nativeMessageChain.contentToString().startsWith("@864812731 ")){
            logger.info("开始聊天...");
            String q = messageContent.getPlainText().replace("@864812731 ","");
            String jtr = HttpUtil.get("http://api.qingyunke.com/api.php?key=free&appid=0&msg="+q);
            Map<String,Object> map = JSON.parseObject(jtr);
            event.sendBlocking(MapUtil.getStr(map,"content").replace("{br}","\n"));
            logger.info("/聊天回答完成...");
        }
    }
}

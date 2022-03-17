package com.rapdog.rapbot.listener.group;

import cn.hutool.core.text.CharSequenceUtil;
import com.rapdog.rapbot.utils.MessageSendUtils;
import com.rapdog.rapbot.api.TikTokUtils;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 抖音分享连接监听
 * @author rapdog
 */
@Component
public class TiktokShareListener {

    private static final Logger logger = LoggerFactory.getLogger(TiktokShareListener.class);

    @Listener
    @Filter(value = "复制此链接，打开Dou音搜索，直接观看视频！", matchType = MatchType.TEXT_ENDS_WITH)
    public void listen(MiraiGroupMessageEvent event) {
        logger.info("监听到抖音分享消息");
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        event.sendBlocking("开始解析，耗时较长，请耐心等待");
        String messageText = nativeMessageChain.contentToString();
        String shareUrl = shareTextToUrl(messageText);
        logger.info("解析抖音分享链接为：{}",shareUrl);
        if (CharSequenceUtil.isEmpty(shareUrl)){
            event.sendBlocking("解析分享链接失败，请检查");
        }else{
            String downLoadPath = System.getProperty("java.io.tmpdir") +
                    "\\"+event.getAuthor().getNickOrUsername()+System.currentTimeMillis()+".mp4";
            try {
                logger.info("开始解析视频地址...");
                String videoUrl = TikTokUtils.getVideoUrl(shareUrl);
                logger.info("解析视频地址成功！开始下载视频...");
                TikTokUtils.downloadNet(videoUrl,downLoadPath);
                logger.info("下载完成！开始上传群文件...");
                File video = new File(downLoadPath);
                MessageSendUtils.sendGroupFile(event,video);
                logger.info("抖音分享视频解析上传完成");
            }catch (Exception e){
                event.sendBlocking(e.getMessage());
            }finally {
                File video = new File(downLoadPath);
                if (video.exists()){
                    boolean delete = video.delete();
                    logger.info("删除视频临时文件：{}",delete);
                }
            }
        }
    }

    public static String shareTextToUrl(String shareText){
        String regex = "(http:|https:)//[^[A-Za-z0-9\\._\\?%&+\\-=/#]]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(shareText);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }


}

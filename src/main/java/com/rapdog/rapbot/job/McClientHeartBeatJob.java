package com.rapdog.rapbot.job;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.rapdog.rapbot.utils.KafkaUtils;
import love.forte.simbot.LoggerFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class McClientHeartBeatJob {

    private static final Logger logger = LoggerFactory.getLogger(McClientHeartBeatJob.class);

    private static boolean isAlive;

    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        ConsumerRecords<String, String> records = KafkaUtils.readOne(1000);
        boolean flag = false;
        for (ConsumerRecord<String, String> record : records) {
            logger.debug("McClientHeartBeatJob->McClientHeartBeatMessage：{}", record.value());
            Date heartbeat = DateUtil.parse(record.value(), DatePattern.NORM_DATETIME_PATTERN);
            // 十秒内心跳有效
            if (DateUtil.date().getTime() - heartbeat.getTime() <= 10000) {
                flag = true;
            }
            // commit消息
            KafkaUtils.getConsumer().commitAsync();
        }
        isAlive = flag;
    }
    public static boolean isMcClientAlive(){
        return isAlive;
    }
}
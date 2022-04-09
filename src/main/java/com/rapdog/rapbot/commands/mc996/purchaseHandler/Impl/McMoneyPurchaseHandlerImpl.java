package com.rapdog.rapbot.commands.mc996.purchaseHandler.Impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.mc996.purchaseHandler.PurchaseHandler;
import com.rapdog.rapbot.exception.InvalidParamException;
import com.rapdog.rapbot.service.McGoodsService;
import com.rapdog.rapbot.service.McUserService;
import com.rapdog.rapbot.utils.KafkaUtils;
import com.rapdog.rapbot.utils.SpringUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 购买金币实现类
 * @author rapdog
 */
public class McMoneyPurchaseHandlerImpl implements PurchaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(McMoneyPurchaseHandlerImpl.class);


    /**
     * 购买1w金币业务处理
     *
     * @return
     */
    @Override
    public ResultVO handle(int goodsId, long qid, int amount) {
        // 从topic中获取客户端的心跳信息，若心跳信息不正确则返回失败
        ConsumerRecords<String, String> records =  KafkaUtils.readOne(1000);
        boolean isClientAlive = false;
        for (ConsumerRecord<String, String> record : records) {
            logger.info("kafka读取到消息：{}",record.value());
            Date heartbeat = DateUtil.parse(record.value(), DatePattern.NORM_DATETIME_PATTERN);
            // 十秒内心跳有效
            if (DateUtil.date().getTime()-heartbeat.getTime() <= 10000){
                isClientAlive = true;
            }
            // commit消息
            KafkaUtils.getConsumer().commitAsync();
        }
        if (isClientAlive){
            // 发送kafka消息
            String topic = "TestTopic";
            McUserService mcUserService = SpringUtil.getBean(McUserService.class);
            McUser user = mcUserService.getUserByQid(qid);
            String mcId = user.getUserMcid();
            String message = "/pay "+ mcId +" "+ 10000*amount;
            logger.info("createing producer");
            KafkaProducer<String, String> producer = KafkaUtils.getProducer();
            logger.info("sending message:[{}] to topic:{}",message,topic);
            KafkaUtils.send(producer, topic, message);
            return ResultVO.ok("购买成功");
        }else {
            throw new InvalidParamException("目前无可用的远程指令接受者，请稍后再试");
        }
    }
}

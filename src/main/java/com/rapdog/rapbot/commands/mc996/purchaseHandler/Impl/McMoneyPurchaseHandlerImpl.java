package com.rapdog.rapbot.commands.mc996.purchaseHandler.Impl;

import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.mc996.purchaseHandler.PurchaseHandler;
import com.rapdog.rapbot.utils.KafkaUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rapdog
 */
public class McMoneyPurchaseHandlerImpl implements PurchaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(McMoneyPurchaseHandlerImpl.class);

    /**
     * 购买业务处理
     *
     * @return
     */
    @Override
    public ResultVO handle(int goodsId, long qid, int amount) {
        // 发送kafka消息

        String servers = "81.70.59.107:9092";
        String topic = "TestTopic";
        String message = "test";

        logger.info("createing producer");
        KafkaProducer<String, String> producer = KafkaUtils.createProducer(servers);
        logger.info("sending message to topic:{}",topic);
        KafkaUtils.send(producer, topic, message);
        return null;
    }
}

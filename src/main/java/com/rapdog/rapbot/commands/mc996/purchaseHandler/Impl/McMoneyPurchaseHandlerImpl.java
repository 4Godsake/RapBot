package com.rapdog.rapbot.commands.mc996.purchaseHandler.Impl;

import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.mc996.purchaseHandler.PurchaseHandler;
import com.rapdog.rapbot.service.McGoodsService;
import com.rapdog.rapbot.service.McUserService;
import com.rapdog.rapbot.utils.KafkaUtils;
import com.rapdog.rapbot.utils.SpringUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    }
}

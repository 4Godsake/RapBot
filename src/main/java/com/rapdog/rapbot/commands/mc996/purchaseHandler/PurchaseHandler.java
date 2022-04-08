package com.rapdog.rapbot.commands.mc996.purchaseHandler;

import com.rapdog.rapbot.bean.result.ResultVO;

public interface PurchaseHandler {

    /**
     * 购买业务处理
     * @return
     */
    ResultVO handle(int goodsId, long qid, int amount);
}

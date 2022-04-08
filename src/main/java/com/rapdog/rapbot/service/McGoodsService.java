package com.rapdog.rapbot.service;

import com.rapdog.rapbot.bean.bo.McGoods;
import com.rapdog.rapbot.bean.result.ResultVO;

import java.util.List;

/**
 * @author rapdog
 */
public interface McGoodsService {

    /**
     * 获取商品列表
     * @return List<McGoods>
     */
    List<McGoods> getGoodsList();

    /**
     * 购买商品
     * @param goodsId 商品id
     * @param qid qq
     * @param amount 数量
     * @return
     */
    ResultVO buyGoodsById(int goodsId, long qid, int amount) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}

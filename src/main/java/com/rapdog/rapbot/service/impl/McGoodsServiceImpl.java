package com.rapdog.rapbot.service.impl;

import com.rapdog.rapbot.bean.bo.McGoods;
import com.rapdog.rapbot.bean.bo.McGoodsExample;
import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.commands.mc996.purchaseHandler.PurchaseHandler;
import com.rapdog.rapbot.exception.InvalidParamException;
import com.rapdog.rapbot.mapper.McGoodsMapper;
import com.rapdog.rapbot.mapper.McUserMapper;
import com.rapdog.rapbot.service.McGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class McGoodsServiceImpl implements McGoodsService {

    private static final Logger logger = LoggerFactory.getLogger(McGoodsServiceImpl.class);

    @Autowired
    private McGoodsMapper goodsMapper;

    @Autowired
    private McUserMapper userMapper;
    /**
     * 获取商品列表
     *
     * @return List<McGoods>
     */
    @Override
    public List<McGoods> getGoodsList() {
        List<McGoods> list = goodsMapper.selectByExample(new McGoodsExample());
        logger.info("查询到的商品列表：{}",list);
        return list;
    }

    /**
     * 购买商品
     *
     * @param goodsId 商品id
     * @param qid     qq
     * @param amount  数量
     * @return
     */
    @Override
    public ResultVO buyGoodsById(int goodsId, long qid, int amount) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        McGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
        McUser user = userMapper.selectByPrimaryKey(qid);
        if (goods == null){
            throw new InvalidParamException("购买失败-商品id有误");
        }
        if (user == null){
            throw new InvalidParamException("购买失败-未绑定账号");
        }
        if (goods.getGoodsInventory() < amount){
            throw new InvalidParamException("购买失败-商品库存不足");
        }
        if (goods.getGoodsPrice()*amount > user.getUserPoint()){
            throw new InvalidParamException("购买失败-余额不足");
        }
        // 开始处理业务
        PurchaseHandler handler = (PurchaseHandler) Class.forName(goods.getGoodsClassName()).newInstance();
        ResultVO result = handler.handle(goodsId, qid, amount);

        // 扣钱
        user.setUserPoint(user.getUserPoint()-goods.getGoodsPrice()*amount);
        userMapper.updateByPrimaryKey(user);
        // 减库存
        goods.setGoodsInventory(goods.getGoodsInventory()-amount);
        goodsMapper.updateByPrimaryKey(goods);

        return result;
    }
}

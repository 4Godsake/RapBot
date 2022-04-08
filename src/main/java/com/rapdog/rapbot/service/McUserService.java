package com.rapdog.rapbot.service;

import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.result.ResultVO;

public interface McUserService {

    /**
     * 绑定mcId和qq
     * @param qId qq
     * @param mcId mcId
     * @return BaseResultMap
     */
    ResultVO bindUser(long qId, String mcId);

    /**
     * 根据qq查询用户信息
     * @param qId qq
     * @return ResultVO
     */
    McUser getUserByQid(long qId);

    /**
     * 转账命令
     * @param fromId 支付人qq
     * @param toId 收款人qq
     * @param amount 款项
     * @return ResultVO
     */
    ResultVO pay(long fromId, long toId, float amount);
}

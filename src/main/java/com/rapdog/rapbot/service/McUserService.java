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
    ResultVO bindUser(int qId, String mcId);

    /**
     * 根据qq查询用户信息
     * @param qId qq
     * @return ResultVO
     */
    McUser getUserByQid(int qId);
}

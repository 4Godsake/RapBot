package com.rapdog.rapbot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.result.ResultVO;
import com.rapdog.rapbot.exception.InvalidParamException;
import com.rapdog.rapbot.mapper.McUserMapper;
import com.rapdog.rapbot.service.McUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class McUserServiceImpl implements McUserService {

    private static final Logger logger = LoggerFactory.getLogger(McUserServiceImpl.class);

    @Autowired
    private McUserMapper mcUserMapper;

    /**
     * 绑定mcId和qq
     *
     * @param qId  qq
     * @param mcId mcId
     * @return BaseResultMap
     */
    @Override
    public ResultVO bindUser(long qId, String mcId) {

        logger.info("McUserServiceImpl -> 绑定用户入参qid:{},mcId:{}",qId,mcId);

        // 判断qId是否已有绑定
        if (mcUserMapper.selectByPrimaryKey(qId) != null){
            return ResultVO.error("qq已被绑定，请勿重复绑定");
        }
        // 判断mcId是否已被绑定
        if (mcUserMapper.selectByUserMcid(mcId) != null){
            return ResultVO.error("该mcId已被绑定，请勿重复绑定");
        }
        McUser user = new McUser();
        user.setUserQid(qId);
        user.setUserMcid(mcId);
        user.setCreateTime(DateUtil.date());
        user.setUserPoint(0);
        user.setMcPosition("成员");
        return mcUserMapper.insertSelective(user) == 1 ? ResultVO.ok() : ResultVO.error();
    }

    /**
     * 根据qq查询用户信息
     *
     * @param qId qq
     * @return ResultVO
     */
    @Override
    public McUser getUserByQid(long qId) {
        return mcUserMapper.selectByPrimaryKey(qId);
    }

    /**
     * 转账命令
     *
     * @param fromId 支付人qq
     * @param toId   收款人qq
     * @param amount 款项
     * @return ResultVO
     */
    @Override
    public ResultVO pay(long fromId, long toId, int amount) throws InvalidParamException {
        logger.info("McUserServiceImpl -> 转账入参fromId:{},toId:{},amount:{}",fromId,toId,amount);
        McUser fromUser = mcUserMapper.selectByPrimaryKey(fromId);
        McUser toUser = mcUserMapper.selectByPrimaryKey(toId);
        if (fromUser == null){
            throw new InvalidParamException("您还没有绑定用户信息，请发送/mcbind 我的世界id 绑定");
        }
        if (toUser == null){
            throw new InvalidParamException("对方还没有绑定用户信息，请发送/mcbind 我的世界id 绑定");
        }
        if (fromUser.getUserPoint() < amount){
            throw new InvalidParamException("没钱付个锤子");
        }
        fromUser.setUserPoint(fromUser.getUserPoint()-amount);
        toUser.setUserPoint(toUser.getUserPoint()+amount);
        mcUserMapper.updateByPrimaryKey(fromUser);
        mcUserMapper.updateByPrimaryKey(toUser);
        return ResultVO.ok("支付成功");
    }
}

package com.rapdog.rapbot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.rapdog.rapbot.bean.bo.RepeatGroup;
import com.rapdog.rapbot.bean.bo.RepeatGroupExample;
import com.rapdog.rapbot.mapper.RepeatGroupMapper;
import com.rapdog.rapbot.service.RepeatGroupService;
import love.forte.simbot.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复读群映射关系service
 * @author rapdog
 */
@Service
public class RepeatGroupServiceImpl implements RepeatGroupService {

    private static final Logger logger = LoggerFactory.getLogger(RepeatGroupServiceImpl.class);

    private static final int TOGGLE_ON = 1;

    private static final int TOGGLE_OFF = 0;

    @Autowired
    private RepeatGroupMapper repeatGroupMapper;

    /**
     * 查出全部复读群映射关系
     * @return Map<Long, Boolean>
     */
    @Override
    public Map<Long, Boolean> getAllRepeatGroup() {
        logger.info("=== start RepeatGroupService.getAllRepeatGroup() ===");
        Map<Long, Boolean> repeatGroupMap = new HashMap<>();
        RepeatGroupExample example = new RepeatGroupExample();
        List<RepeatGroup> groupList = repeatGroupMapper.selectByExample(example);
        groupList.forEach(group -> repeatGroupMap.put(group.getGroupId(), group.getToggle() == TOGGLE_ON));
        logger.info("=== RepeatGroupService.getAllRepeatGroup() end ===");
        return repeatGroupMap;
    }

    /**
     * 新增或更新群复读开启关系
     */
    @Override
    public void addOrUpdateRepeatGroup(Long groupId) {
        logger.info("=== start RepeatGroupService.addOrUpdateRepeatGroup({}) ===",groupId);
        RepeatGroup group = new RepeatGroup();
        group.setGroupId(groupId);
        group.setToggle(TOGGLE_ON);
        if (repeatGroupMapper.selectByPrimaryKey(groupId) != null){
            group.setUpdateTime(DateUtil.date());
            int flag = repeatGroupMapper.updateByPrimaryKeySelective(group);
            logger.info("群{}有记录 -> 更新 -> 更新状态{}",groupId,flag);
        }else {
            group.setCreateTime(DateUtil.date());
            int flag = repeatGroupMapper.insertSelective(group);
            logger.info("群{}无记录 -> 新增 -> 新增状态{}",groupId,flag);
        }
        logger.info("=== RepeatGroupService.addOrUpdateRepeatGroup() end ===");
    }

    /**
     * 将群复读开关关闭，实际为一次update
     */
    @Override
    public void removeRepeatGroup(Long groupId) {
        logger.info("=== start RepeatGroupService.removeRepeatGroup({}) ===",groupId);
        RepeatGroup group = new RepeatGroup();
        group.setGroupId(groupId);
        group.setToggle(TOGGLE_OFF);
        group.setUpdateTime(DateUtil.date());
        int flag = repeatGroupMapper.updateByPrimaryKeySelective(group);
        logger.info("群{}复读开关关闭 -> 更新 -> 更新状态{}",groupId,flag);
        logger.info("=== RepeatGroupService.removeRepeatGroup() end ===");
    }
}

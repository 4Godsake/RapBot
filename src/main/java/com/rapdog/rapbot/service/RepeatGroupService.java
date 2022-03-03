package com.rapdog.rapbot.service;

import java.util.Map;

/**
 * @author rapdog
 */
public interface RepeatGroupService {

    /**
     * 查出全部复读群映射关系
     * @return Map<Long, Boolean>
     */
    Map<Long, Boolean> getAllRepeatGroup();

    /**
     * 新增或更新群复读开启关系
     * @param groupId 群id
     */
    void addOrUpdateRepeatGroup(Long groupId);

    /**
     * 将群复读开关关闭
     * @param groupId 群id
     */
    void removeRepeatGroup(Long groupId);

}

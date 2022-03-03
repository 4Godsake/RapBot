package com.rapdog.rapbot.utils;

import cn.hutool.core.map.MapUtil;
import com.rapdog.rapbot.service.RepeatGroupService;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于缓存群复读状态
 * @author rapdog
 */
public class RepeatActiveGroupUtils {

    private static Map<Long, Boolean> repeatGroupMap = new HashMap<>(64);

    public static void initGroupMap(){
        RepeatGroupService repeatGroupService = SpringUtil.getBean(RepeatGroupService.class);
        repeatGroupMap = repeatGroupService.getAllRepeatGroup();
    }

    public static boolean isGroupToggleOn(Long groupId){
        if (MapUtil.isEmpty(repeatGroupMap)){
            initGroupMap();
        }
        return repeatGroupMap.getOrDefault(groupId,false);
    }

    public static void addGroup(Long groupId){
        if (MapUtil.isEmpty(repeatGroupMap)){
            initGroupMap();
        }
        RepeatGroupService repeatGroupService = SpringUtil.getBean(RepeatGroupService.class);
        repeatGroupService.addOrUpdateRepeatGroup(groupId);
        repeatGroupMap.put(groupId,Boolean.TRUE);
    }

    public static void removeGroup(Long groupId){
        if (MapUtil.isEmpty(repeatGroupMap)){
            initGroupMap();
        }
        RepeatGroupService repeatGroupService = SpringUtil.getBean(RepeatGroupService.class);
        repeatGroupService.removeRepeatGroup(groupId);
        repeatGroupMap.put(groupId,Boolean.FALSE);
    }
}


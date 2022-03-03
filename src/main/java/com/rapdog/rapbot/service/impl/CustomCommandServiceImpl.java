package com.rapdog.rapbot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.rapdog.rapbot.bean.bo.CustomCommand;
import com.rapdog.rapbot.bean.bo.CustomCommandGroupRlt;
import com.rapdog.rapbot.bean.bo.CustomCommandGroupRltExample;
import com.rapdog.rapbot.mapper.CustomCommandGroupRltMapper;
import com.rapdog.rapbot.mapper.CustomCommandMapper;
import com.rapdog.rapbot.service.CustomCommandService;
import com.rapdog.rapbot.utils.CommandUtils;
import love.forte.simbot.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rapdog
 */
@Service
public class CustomCommandServiceImpl implements CustomCommandService {

    private static final Logger logger = LoggerFactory.getLogger(CustomCommandServiceImpl.class);

    @Autowired
    private CustomCommandMapper customCommandMapper;

    @Autowired
    private CustomCommandGroupRltMapper rltMapper;

    /**
     * 绑定自定义命令
     *
     * @param command 命令字符
     * @param reply   回复语
     * @param creator 命令创建者
     */
    @Override
    public String bindCustomCommand(String command, String reply, Long creator, Long groupId) {
        logger.info("用户【{}】绑定自定义回复：【{}-{}】，群【{}】",creator,command,reply,groupId);

        CustomCommand oldCommand = customCommandMapper.selectRltByPrimaryKey(command);
        if (oldCommand != null) {
            // 已有命令
            if (!CommandUtils.customCommandMap.get(command).getActiveGroups().contains(groupId)) {
                // 当前群无映射
                if (oldCommand.getReplyStr().equals(reply)) {
                    // 回复语相同的情况
                    newCustomCommandRlt(command, groupId);
                    // 刷新自定义指令列表
                    CommandUtils.initCustomCommandMap();
                    return "新增回复语成功";
                } else {
                    // 已有命令，当前群无映射，回复语不同
                    return "这条命令已经在其他群绑定了不一样的回复语哦，无法覆盖";
                }
            }
            return "这条命令已经有回复语啦！";
        } else {
            CustomCommand newCommand = new CustomCommand();
            newCommand.setCommandStr(command);
            newCommand.setCreateQid(creator);
            newCommand.setReplyStr(reply);
            newCommand.setCreateTime(DateUtil.date());
            customCommandMapper.insertSelective(newCommand);
            if (groupId != null) {
                newCustomCommandRlt(command, groupId);
            }
            // 刷新自定义指令列表
            CommandUtils.initCustomCommandMap();
            return "新增回复语成功";
        }
    }

    /**
     * 解绑自定义命令
     *
     * @param command 命令字符
     */
    @Override
    public String unbindCustomCommand(String command) {
        logger.info("解绑命令：{}",command);
        customCommandMapper.deleteByPrimaryKey(command);
        CustomCommandGroupRltExample example = new CustomCommandGroupRltExample();
        CustomCommandGroupRltExample.Criteria criteria = example.createCriteria();
        criteria.andCommandStrEqualTo(command);
        rltMapper.deleteByExample(example);
        CommandUtils.initCustomCommandMap();
        return "删除自定义回复成功";
    }

    /**
     * 返回是否为自定义命令
     *
     * @param command 命令字符
     * @return boolean
     */
    @Override
    public boolean isCustomCommand(String command) {
        return customCommandMapper.selectByPrimaryKey(command) != null;
    }

    /**
     * 返回所有指令-回复的映射map
     *
     * @return Map<String, CustomCommand>
     */
    @Override
    public Map<String, CustomCommand> getAllCustomCommandMap() {
        logger.info("开始获取全量自定义指令映射图");
        Map<String, CustomCommand> rltMap = new HashMap<>();
        List<CustomCommand> customCommandList = customCommandMapper.selectAllRlt();
        customCommandList.forEach(cc -> rltMap.put(cc.getCommandStr(), cc));
        return rltMap;
    }

    /**
     * 返回指令回复语
     *
     * @param command 指令
     * @return String
     */
    @Override
    public String getCustomCommandReply(String command) {
        CustomCommand customCommand = customCommandMapper.selectByPrimaryKey(command);
        return customCommand.getReplyStr();
    }

    private void newCustomCommandRlt(String command, Long groupId) {
        CustomCommandGroupRlt commandGroupRlt = new CustomCommandGroupRlt();
        commandGroupRlt.setCommandStr(command);
        commandGroupRlt.setActiveGroup(groupId);
        commandGroupRlt.setCreateTime(DateUtil.date());
        rltMapper.insertSelective(commandGroupRlt);
    }
}

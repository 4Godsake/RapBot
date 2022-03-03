package com.rapdog.rapbot.mapper;

import com.rapdog.rapbot.bean.bo.RepeatGroup;
import com.rapdog.rapbot.bean.bo.RepeatGroupExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RepeatGroupMapper {
    long countByExample(RepeatGroupExample example);

    int deleteByExample(RepeatGroupExample example);

    int deleteByPrimaryKey(Long groupId);

    int insert(RepeatGroup record);

    int insertSelective(RepeatGroup record);

    List<RepeatGroup> selectByExample(RepeatGroupExample example);

    RepeatGroup selectByPrimaryKey(Long groupId);

    int updateByExampleSelective(@Param("record") RepeatGroup record, @Param("example") RepeatGroupExample example);

    int updateByExample(@Param("record") RepeatGroup record, @Param("example") RepeatGroupExample example);

    int updateByPrimaryKeySelective(RepeatGroup record);

    int updateByPrimaryKey(RepeatGroup record);
}
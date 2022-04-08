package com.rapdog.rapbot.mapper;

import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.bean.bo.McUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface McUserMapper {
    long countByExample(McUserExample example);

    int deleteByExample(McUserExample example);

    int deleteByPrimaryKey(Long userQid);

    int insert(McUser record);

    int insertSelective(McUser record);

    List<McUser> selectByExample(McUserExample example);

    McUser selectByPrimaryKey(Long userQid);

    McUser selectByUserMcid(String userMcid);

    int updateByExampleSelective(@Param("record") McUser record, @Param("example") McUserExample example);

    int updateByExample(@Param("record") McUser record, @Param("example") McUserExample example);

    int updateByPrimaryKeySelective(McUser record);

    int updateByPrimaryKey(McUser record);
}
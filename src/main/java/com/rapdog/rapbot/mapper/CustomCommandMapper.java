package com.rapdog.rapbot.mapper;

import com.rapdog.rapbot.bean.bo.CustomCommand;
import com.rapdog.rapbot.bean.bo.CustomCommandExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomCommandMapper {
    long countByExample(CustomCommandExample example);

    int deleteByExample(CustomCommandExample example);

    int deleteByPrimaryKey(String commandStr);

    int insert(CustomCommand record);

    int insertSelective(CustomCommand record);

    List<CustomCommand> selectByExample(CustomCommandExample example);

    CustomCommand selectByPrimaryKey(String commandStr);

    int updateByExampleSelective(@Param("record") CustomCommand record, @Param("example") CustomCommandExample example);

    int updateByExample(@Param("record") CustomCommand record, @Param("example") CustomCommandExample example);

    int updateByPrimaryKeySelective(CustomCommand record);

    int updateByPrimaryKey(CustomCommand record);

    List<CustomCommand> selectAllRlt();

    CustomCommand selectRltByPrimaryKey(String commandStr);
}
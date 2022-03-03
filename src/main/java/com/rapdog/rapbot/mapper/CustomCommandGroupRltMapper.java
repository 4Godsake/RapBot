package com.rapdog.rapbot.mapper;

import com.rapdog.rapbot.bean.bo.CustomCommandGroupRlt;
import com.rapdog.rapbot.bean.bo.CustomCommandGroupRltExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomCommandGroupRltMapper {
    long countByExample(CustomCommandGroupRltExample example);

    int deleteByExample(CustomCommandGroupRltExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomCommandGroupRlt record);

    int insertSelective(CustomCommandGroupRlt record);

    List<CustomCommandGroupRlt> selectByExample(CustomCommandGroupRltExample example);

    CustomCommandGroupRlt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomCommandGroupRlt record, @Param("example") CustomCommandGroupRltExample example);

    int updateByExample(@Param("record") CustomCommandGroupRlt record, @Param("example") CustomCommandGroupRltExample example);

    int updateByPrimaryKeySelective(CustomCommandGroupRlt record);

    int updateByPrimaryKey(CustomCommandGroupRlt record);
}
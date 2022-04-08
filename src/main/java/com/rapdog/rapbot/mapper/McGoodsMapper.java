package com.rapdog.rapbot.mapper;

import com.rapdog.rapbot.bean.bo.McGoods;
import com.rapdog.rapbot.bean.bo.McGoodsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface McGoodsMapper {
    long countByExample(McGoodsExample example);

    int deleteByExample(McGoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(McGoods record);

    int insertSelective(McGoods record);

    List<McGoods> selectByExample(McGoodsExample example);

    McGoods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") McGoods record, @Param("example") McGoodsExample example);

    int updateByExample(@Param("record") McGoods record, @Param("example") McGoodsExample example);

    int updateByPrimaryKeySelective(McGoods record);

    int updateByPrimaryKey(McGoods record);
}
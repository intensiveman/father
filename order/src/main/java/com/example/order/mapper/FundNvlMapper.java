package com.example.order.mapper;

import com.example.order.model.FundNvl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FundNvlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FundNvl record);

    int insertSelective(FundNvl record);

    FundNvl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FundNvl record);

    int updateByPrimaryKey(FundNvl record);
}
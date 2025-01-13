package com.example.user.mapper;

import com.example.user.model.FundNvl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FundNvlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FundNvl record);

    int insertSelective(FundNvl record);

    FundNvl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FundNvl record);

    int updateByPrimaryKey(FundNvl record);
}
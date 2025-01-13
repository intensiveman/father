package com.example.order.mapper;

import com.example.order.model.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    int insert(Employee record);

    int insertSelective(Employee record);
}
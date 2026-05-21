package com.example.user.mapper;

import com.example.user.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author System
 * @since 2026-05-19
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}

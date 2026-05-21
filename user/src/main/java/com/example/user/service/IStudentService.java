package com.example.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.user.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author System
 * @since 2026-05-19
 */
public interface IStudentService extends IService<Student> {

    /**
     * 分页查询学生列表
     */
    IPage<Student> pageStudents(Integer current, Integer size, String name, String studentNo, String className);

    /**
     * 根据学号查询学生
     */
    Student getByStudentNo(String studentNo);

    /**
     * 批量删除学生
     */
    boolean batchDelete(List<Long> ids);
}

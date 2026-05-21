package com.example.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.user.entity.Student;
import com.example.user.mapper.StudentMapper;
import com.example.user.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author System
 * @since 2026-05-19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public IPage<Student> pageStudents(Integer current, Integer size, String name, String studentNo, String className) {
        Page<Student> page = new Page<>(current, size);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        if (StrUtil.isNotBlank(studentNo)) {
            queryWrapper.like("student_no", studentNo);
        }
        if (StrUtil.isNotBlank(className)) {
            queryWrapper.eq("class_name", className);
        }
        
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.orderByDesc("create_time");
        
        return this.page(page, queryWrapper);
    }

    @Override
    public Student getByStudentNo(String studentNo) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_no", studentNo);
        queryWrapper.eq("is_deleted", 0);
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean batchDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return false;
        }
        
        List<Student> students = this.listByIds(ids);
        students.forEach(student -> {
            student.setIsDeleted(true);
            student.setUpdateTime(LocalDateTime.now());
        });
        
        return this.updateBatchById(students);
    }
}

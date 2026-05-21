package com.example.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.user.entity.Student;
import com.example.user.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author System
 * @since 2026-05-19
 */
@RestController
@RequestMapping("/student")
@Api(tags = "学生管理")
@CrossOrigin
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/add")
    @ApiOperation("添加学生")
    public Map<String, Object> addStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            Student existStudent = studentService.getByStudentNo(student.getStudentNo());
            if (existStudent != null) {
                result.put("success", false);
                result.put("message", "学号已存在");
                return result;
            }
            
            student.setCreateTime(LocalDateTime.now());
            student.setUpdateTime(LocalDateTime.now());
            student.setIsDeleted(false);
            
            boolean success = studentService.save(student);
            result.put("success", success);
            result.put("message", success ? "添加成功" : "添加失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "添加失败：" + e.getMessage());
        }
        
        return result;
    }

    @PutMapping("/update")
    @ApiOperation("更新学生信息")
    public Map<String, Object> updateStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            student.setUpdateTime(LocalDateTime.now());
            boolean success = studentService.updateById(student);
            result.put("success", success);
            result.put("message", success ? "更新成功" : "更新失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新失败：" + e.getMessage());
        }
        
        return result;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除学生")
    public Map<String, Object> deleteStudent(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            Student student = studentService.getById(id);
            if (student != null) {
                student.setIsDeleted(true);
                student.setUpdateTime(LocalDateTime.now());
                boolean success = studentService.updateById(student);
                result.put("success", success);
                result.put("message", success ? "删除成功" : "删除失败");
            } else {
                result.put("success", false);
                result.put("message", "学生不存在");
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除失败：" + e.getMessage());
        }
        
        return result;
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除学生")
    public Map<String, Object> batchDelete(@RequestBody List<Long> ids) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            boolean success = studentService.batchDelete(ids);
            result.put("success", success);
            result.put("message", success ? "批量删除成功" : "批量删除失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "批量删除失败：" + e.getMessage());
        }
        
        return result;
    }

    @GetMapping("/get/{id}")
    @ApiOperation("根据ID查询学生")
    public Map<String, Object> getStudent(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            Student student = studentService.getById(id);
            result.put("success", true);
            result.put("data", student);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "查询失败：" + e.getMessage());
        }
        
        return result;
    }

    @GetMapping("/getByStudentNo/{studentNo}")
    @ApiOperation("根据学号查询学生")
    public Map<String, Object> getByStudentNo(@PathVariable String studentNo) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            Student student = studentService.getByStudentNo(studentNo);
            result.put("success", true);
            result.put("data", student);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "查询失败：" + e.getMessage());
        }
        
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询学生列表")
    public Map<String, Object> listStudents(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String studentNo,
            @RequestParam(required = false) String className) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            IPage<Student> page = studentService.pageStudents(current, size, name, studentNo, className);
            result.put("success", true);
            result.put("data", page.getRecords());
            result.put("total", page.getTotal());
            result.put("current", page.getCurrent());
            result.put("size", page.getSize());
            result.put("pages", page.getPages());
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "查询失败：" + e.getMessage());
        }
        
        return result;
    }

    @GetMapping("/getAll")
    @ApiOperation("查询所有学生")
    public Map<String, Object> getAllStudents() {
        Map<String, Object> result = new HashMap<>();
        
        try {
            List<Student> students = studentService.list();
            result.put("success", true);
            result.put("data", students);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "查询失败：" + e.getMessage());
        }
        
        return result;
    }
}

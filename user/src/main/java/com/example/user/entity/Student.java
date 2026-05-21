package com.example.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author System
 * @since 2026-05-19
 */
@Data
@TableName("student")
@ApiModel(value = "Student对象", description = "学生信息表")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("学生ID（主键）")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("学号")
    @TableField("student_no")
    private String studentNo;

    @ApiModelProperty("学生姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别（0=女，1=男）")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("身份证号")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty("家庭住址")
    @TableField("address")
    private String address;

    @ApiModelProperty("班级名称")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("专业")
    @TableField("major")
    private String major;

    @ApiModelProperty("学院")
    @TableField("college")
    private String college;

    @ApiModelProperty("入学年份")
    @TableField("enrollment_year")
    private Integer enrollmentYear;

    @ApiModelProperty("状态（0=休学，1=在读，2=毕业，3=退学）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("软删除标记（0=正常，1=删除）")
    @TableField("is_deleted")
    private Boolean isDeleted;
}

package com.example.order.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 工号
    */
    private String workno;

    /**
    * 姓名
    */
    private String name;

    /**
    * 性别
    */
    private String gender;

    /**
    * 年龄
    */
    private Byte age;

    /**
    * 身份证号
    */
    private String idcard;

    /**
    * 入职时间
    */
    private Date entrydate;
}
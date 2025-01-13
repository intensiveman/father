package com.example.user.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基金表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundNvl {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 基金编号
    */
    private String fund;

    /**
    * 净值
    */
    private String nvl;

    /**
    * 日期
    */
    private Date date;
}
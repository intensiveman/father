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
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author YourName
 * @since 2025-04-16
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "系统用户表")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID（主键）")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("唯一用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("BCrypt加密后的密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("账户创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("账户状态（0=禁用，1=启用）")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("软删除标记（0=正常，1=删除）")
    @TableField("is_deleted")
    private Boolean isDeleted;
}

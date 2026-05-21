package com.example.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 权限明细表
 * </p>
 *
 * @author YourName
 * @since 2025-05-12
 */
@Getter
@Setter
@TableName("permission")
@ApiModel(value = "Permission对象", description = "权限明细表")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限ID（主键）")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("权限名称（如查询用户）")
    @TableField("perm_name")
    private String permName;

    @ApiModelProperty("权限标识（如user:list）")
    @TableField("perm_key")
    private String permKey;

    @ApiModelProperty("权限类型（1=菜单，2=按钮/API）")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty("父权限ID（0表示顶级）")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("前端路由路径")
    @TableField("path")
    private String path;

    @ApiModelProperty("菜单图标样式")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("显示排序号")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;
}

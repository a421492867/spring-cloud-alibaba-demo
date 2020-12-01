package com.lordy.shop.shop_api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lordy.commons.database.entity.BaseEntity;

@TableName("goods")
public class Goods extends BaseEntity {

    @TableField
    private String name;

    @TableField
    private Integer stock;

    @TableField
    private double price;

    @TableField
    private String description;

    @TableField
    private String createTime;

}

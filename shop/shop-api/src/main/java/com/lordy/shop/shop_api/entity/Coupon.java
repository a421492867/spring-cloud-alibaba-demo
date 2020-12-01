package com.lordy.shop.shop_api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lordy.commons.database.entity.BaseEntity;

@TableName("coupon")
public class Coupon extends BaseEntity {

    @TableField
    private double couponPrice;

    @TableField
    private Integer userId;

    @TableField
    private Integer orderId;

    @TableField
    private String isUsed;

    @TableField
    private String usedTime;

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(String usedTime) {
        this.usedTime = usedTime;
    }
}

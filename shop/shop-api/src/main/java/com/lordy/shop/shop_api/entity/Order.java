package com.lordy.shop.shop_api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lordy.commons.database.entity.BaseEntity;

@TableName("order")
public class Order extends BaseEntity {

    @TableField
    private Integer userId;

    //订单状态
    @TableField
    private String orderStatus;

    //支付状态
    @TableField
    private String payStatus;

    @TableField
    private Integer goodId;

    //商品量
    @TableField
    private Integer goodNum;

    //商品单价
    @TableField
    private double goodPrice;

    //订单总金额
    @TableField
    private double orderTotal;


    @TableField
    private Integer couponId;

    //优惠券金额
    @TableField
    private double couponPaid;

    //用户付钱的金额
    @TableField
    private double moneyPaid;

    @TableField
    private String createTime;

    @TableField
    private String confirmTime;

    @TableField
    private String payTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public double getCouponPaid() {
        return couponPaid;
    }

    public void setCouponPaid(double couponPaid) {
        this.couponPaid = couponPaid;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
}

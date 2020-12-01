package com.lordy.shop.shop_api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lordy.commons.database.entity.BaseEntity;

@TableName("order")
public class Order extends BaseEntity {

    @TableField
    private Integer userId;

    @TableField
    private String orderStatus;

    @TableField
    private String payStatus;

    @TableField
    private String shippingStatus;

    @TableField
    private String address;

    @TableField
    private String consigee;

    @TableField
    private Integer goodId;

    @TableField
    private Integer goodNum;

    @TableField
    private double goodPrice;

    @TableField
    private double goodAmount;

    @TableField
    private double shippingFee;

    @TableField
    private double orderAmount;

    @TableField
    private Integer couponId;

    @TableField
    private double couponPaid;

    @TableField
    private double moneyPaid;

    @TableField
    private double payAmount;

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

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsigee() {
        return consigee;
    }

    public void setConsigee(String consigee) {
        this.consigee = consigee;
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

    public double getGoodAmount() {
        return goodAmount;
    }

    public void setGoodAmount(double goodAmount) {
        this.goodAmount = goodAmount;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
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

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
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

package com.lordy.business.business_shop.service;

import com.lordy.commons.database.config.CommonConfig;
import com.lordy.commons.web.api.Response;
import com.lordy.shop.shop_api.api.CouponService;
import com.lordy.shop.shop_api.api.GoodsService;
import com.lordy.shop.shop_api.api.OrderService;
import com.lordy.shop.shop_api.entity.Coupon;
import com.lordy.shop.shop_api.entity.Goods;
import com.lordy.shop.shop_api.entity.Order;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderBusinessService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private OrderService orderService;

    @Reference
    private GoodsService goodsService;

    @Reference
    private UserService userService;

    @Reference
    private CouponService couponService;

    public Response confirmOrder(Order order){
        try {
            checkOrder(order);
        }catch (Exception e){

        }
        return null;
    }

    private Integer savePreOrder(Order order) throws Exception{
        order.setOrderStatus("0");
        double totalGoodsPrice = order.getGoodPrice() * order.getGoodNum();
        if(order.getGoodAmount() != totalGoodsPrice){
            throw new Exception("订单价格不正确");
        }
        Integer couponId = order.getCouponId();
        if(couponId != null){
            Coupon coupon = couponService.selectById(couponId);
            if(coupon == null){
                throw new Exception("没有该优惠券");
            }
            if("1".equals(coupon.getIsUsed())){
                throw new Exception("优惠券已被使用");
            }
        }else {
            order.setCouponPaid(0);
        }
        double total = order.getOrderAmount() - order.getCouponPaid();
        order.setPayAmount(total);
        order.setCreateTime(CommonConfig.sdf.format(new Date()));
        Integer id = orderService.insertOrder(order);
        return id;

    }


    private void checkOrder(Order order) throws Exception {
        if(order == null){
            throw new Exception("订单不能为空");
        }
        Goods goods = goodsService.findGoodById(order.getGoodId());
        if(goods == null){
            throw new Exception("没有此商品");
        }
        User user = userService.selectUserById(order.getUserId());
        if(user == null){
            throw new Exception("没有此用户");
        }
        if(order.getGoodPrice() != goods.getPrice()){
            throw new Exception("订单价格 不正确");
        }
        if(order.getGoodNum() > goods.getStock()){
            throw new Exception("商品库存不足");
        }
        logger.info("校验订单通过");
    }



}

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

    public Response confirmOrder(Order order) throws Exception{
        if(!checkOrder(order)){
            throw new Exception("订单不合法");
        }
        return null;
    }


    private boolean checkOrder(Order order){
        if(order == null){
            return false;
        }
        Integer userId = order.getUserId();
        User user = userService.selectUserById(userId);
        if(user == null){
            return false;
        }
        Integer goodId = order.getGoodId();
        Goods goods = goodsService.findGoodById(goodId);
        if(goods == null){
            return false;
        }
        if(goods.getPrice() != order.getGoodPrice()){
            return false;
        }
        if(order.getGoodNum() < goods.getStock()){
            return false;
        }
        double orderTotal = order.getOrderTotal();
        if(orderTotal != goods.getPrice() * order.getGoodNum()){
            return false;
        }
        return true;
    }



}

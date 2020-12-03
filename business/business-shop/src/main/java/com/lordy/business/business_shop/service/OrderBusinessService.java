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
        }catch (Exception e){

        }
        return null;
    }



}

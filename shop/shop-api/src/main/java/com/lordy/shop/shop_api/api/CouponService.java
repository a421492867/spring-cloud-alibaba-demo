package com.lordy.shop.shop_api.api;

import com.lordy.shop.shop_api.entity.Coupon;
import com.lordy.shop.shop_api.entity.Order;

public interface CouponService {

    Coupon selectById(Integer id);

    boolean useCoupon(Order order);
}

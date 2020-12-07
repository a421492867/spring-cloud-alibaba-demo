package com.lordy.shop.shop_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.shop.shop_api.api.CouponService;
import com.lordy.shop.shop_api.entity.Coupon;
import com.lordy.shop.shop_api.entity.Order;
import com.lordy.shop.shop_service.mapper.CouponMapper;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Coupon selectById(Integer id) {
        if(id == null){
            return null;
        }
        return selectById(id);
    }

    @Override
    public boolean useCoupon(Order order) {
        Coupon coupon = selectById(order.getCouponId());
        coupon.setIsUsed("1");
        return updateById(coupon);
    }
}

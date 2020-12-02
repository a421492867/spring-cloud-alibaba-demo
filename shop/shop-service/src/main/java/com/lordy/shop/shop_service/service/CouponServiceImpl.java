package com.lordy.shop.shop_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.shop.shop_api.api.CouponService;
import com.lordy.shop.shop_api.entity.Coupon;
import com.lordy.shop.shop_service.mapper.CouponMapper;
import org.apache.dubbo.config.annotation.Service;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
}

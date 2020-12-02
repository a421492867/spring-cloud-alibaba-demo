package com.lordy.business.business_shop.service;

import com.lordy.shop.shop_api.api.CouponService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class CouponBusinessService {

    @Reference
    private CouponService couponService;
}

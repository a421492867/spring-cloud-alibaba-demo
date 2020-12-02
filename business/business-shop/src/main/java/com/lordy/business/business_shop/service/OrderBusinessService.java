package com.lordy.business.business_shop.service;

import com.lordy.shop.shop_api.api.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class OrderBusinessService {

    @Reference
    private OrderService orderService;
}

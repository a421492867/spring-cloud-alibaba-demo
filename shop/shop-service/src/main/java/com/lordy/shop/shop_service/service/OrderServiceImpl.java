package com.lordy.shop.shop_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.commons.web.api.Response;
import com.lordy.shop.shop_api.api.OrderService;
import com.lordy.shop.shop_api.entity.Order;
import com.lordy.shop.shop_service.mapper.OrderMapper;
import org.apache.dubbo.config.annotation.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


    @Override
    public Integer insertOrder(Order order) {
        insert(order);
        return order.getId();
    }
}

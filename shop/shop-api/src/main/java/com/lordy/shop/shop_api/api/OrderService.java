package com.lordy.shop.shop_api.api;

import com.lordy.commons.web.api.Response;
import com.lordy.shop.shop_api.entity.Order;

public interface OrderService {

    Response confirmOrder(Order order);
}

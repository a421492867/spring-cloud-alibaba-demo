package com.lordy.shop.shop_api.api;

import com.lordy.shop.shop_api.entity.Goods;
import com.lordy.shop.shop_api.entity.Order;

public interface GoodsService {

    Goods findGoodById(Integer id);

    boolean reduceGoodNum(Order order);
}

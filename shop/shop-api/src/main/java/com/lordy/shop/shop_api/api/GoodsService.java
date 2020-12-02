package com.lordy.shop.shop_api.api;

import com.lordy.shop.shop_api.entity.Goods;

public interface GoodsService {

    Goods findGoodById(Integer id);
}

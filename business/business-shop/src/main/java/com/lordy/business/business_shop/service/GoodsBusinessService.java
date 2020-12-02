package com.lordy.business.business_shop.service;

import com.lordy.shop.shop_api.api.GoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class GoodsBusinessService {

    @Reference
    private GoodsService goodsService;
}

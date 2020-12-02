package com.lordy.shop.shop_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.shop.shop_api.api.GoodsService;
import com.lordy.shop.shop_api.entity.Goods;
import com.lordy.shop.shop_service.mapper.GoodsMapper;
import org.apache.dubbo.config.annotation.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}

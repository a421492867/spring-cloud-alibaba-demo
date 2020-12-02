package com.lordy.shop.shop_service.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lordy.shop.shop_api.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}

package com.lordy.shop.shop_service.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lordy.shop.shop_api.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

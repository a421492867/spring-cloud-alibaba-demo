package com.lordy.shop.shop_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.shop.shop_api.api.GoodsService;
import com.lordy.shop.shop_api.entity.Goods;
import com.lordy.shop.shop_api.entity.Order;
import com.lordy.shop.shop_service.mapper.GoodsMapper;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Goods findGoodById(Integer id) {
        if(id == null){
            return null;
        }
        return selectById(id);
    }

    @Override
    public boolean reduceGoodNum(Order order) {
        //todo redission lock
        Integer goodId = order.getGoodId();
        Goods goods = findGoodById(goodId);
        if(goods.getStock() < order.getGoodNum()){
            return false;
        }
        Integer goodNum = goods.getStock() - order.getGoodNum();
        goods.setStock(goodNum);
        updateById(goods);
        logger.info("扣减库存[" + goodId + "]成功 扣减了[" + order.getGoodNum() + "]个");

        //todo log记录
        return true;
    }
}

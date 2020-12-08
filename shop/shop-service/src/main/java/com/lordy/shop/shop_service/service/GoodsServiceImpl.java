package com.lordy.shop.shop_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.shop.shop_api.api.GoodsService;
import com.lordy.shop.shop_api.entity.Goods;
import com.lordy.shop.shop_api.entity.Order;
import com.lordy.shop.shop_service.mapper.GoodsMapper;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedissonClient redissonClient;

    @Override
    public Goods findGoodById(Integer id) {
        if(id == null){
            return null;
        }
        return selectById(id);
    }

    @Override
    public boolean reduceGoodNum(Order order) {
        // redission lock
        RLock lock = redissonClient.getLock("lock");
        lock.lock(15, TimeUnit.SECONDS);
        try {
            Integer goodId = order.getGoodId();
            Goods goods = findGoodById(goodId);
            if(goods.getStock() < order.getGoodNum()){
                return false;
            }
            Integer goodNum = goods.getStock() - order.getGoodNum();
            goods.setStock(goodNum);
            updateById(goods);
        }finally {
            lock.unlock();
        }
        logger.info("扣减库存[" + order.getGoodId() + "]成功 扣减了[" + order.getGoodNum() + "]个");

        //todo log记录
        return true;
    }
}

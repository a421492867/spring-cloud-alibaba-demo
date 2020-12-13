package com.lordy.business.business_shop.service;

import com.lordy.commons.database.config.CommonConfig;
import com.lordy.commons.web.api.Response;
import com.lordy.shop.shop_api.api.CouponService;
import com.lordy.shop.shop_api.api.GoodsService;
import com.lordy.shop.shop_api.api.OrderService;
import com.lordy.shop.shop_api.entity.Coupon;
import com.lordy.shop.shop_api.entity.Goods;
import com.lordy.shop.shop_api.entity.Order;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderBusinessService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private OrderService orderService;

    @Reference
    private GoodsService goodsService;

    @Reference
    private UserService userService;

    @Reference
    private CouponService couponService;


    public Response confirmOrder(Order order){
        if(!checkOrder(order)){
            return Response.error();
        }
        Integer orderId = savePreOrder(order);
        if(orderId == 0){
            return Response.error();
        }
        try {
            //扣减库存
            reduceGoodNum(order);
            //扣减优惠券
            useCoupon(order);
            //支付
            pay(order);
            //成功
            return Response.success();
        }catch (Exception e){
            //消息队列发送消息 失败 回退

            //返回失败
        }
        return null;
    }

    public void pay(Order order){

    }

    public void reduceGoodNum(Order order) throws Exception{
        boolean result = goodsService.reduceGoodNum(order);
        if(!result){
            throw new Exception("扣减库存失败");
        }
    }

    public void useCoupon(Order order) throws Exception{
        boolean result = couponService.useCoupon(order);
        if(!result){
            throw new Exception("优惠券使用失败");
        }
    }

    private Integer savePreOrder(Order order){
        order.setOrderStatus("0");
        double totalGoodsPrice = order.getGoodPrice() * order.getGoodNum();
        if(order.getOrderTotal() != totalGoodsPrice){
            return 0;
        }
        Integer couponId = order.getCouponId();
        if(couponId != null){
            Coupon coupon = couponService.selectById(couponId);
            if(coupon == null){
                return 0;
            }
            if("1".equals(coupon.getIsUsed())){
                return 0;
            }
        }else {
            order.setCouponPaid(0);
        }
        double total = order.getOrderTotal() - order.getCouponPaid();
        order.setMoneyPaid(total);
        order.setCreateTime(CommonConfig.sdf.format(new Date()));
        Integer id = orderService.insertOrder(order);
        logger.info("preOrder [" + id + "] 生成");
        return id;
    }


    private boolean checkOrder(Order order) {
        if(order == null){
            return false;
        }
        Goods goods = goodsService.findGoodById(order.getGoodId());
        if(goods == null){
            return false;
        }
        User user = userService.selectUserById(order.getUserId());
        if(user == null){
            return false;
        }
        if(order.getGoodPrice() != goods.getPrice()){
            return false;
        }
        if(order.getGoodNum() > goods.getStock()){
            return false;
        }
        logger.info("校验订单通过");
        return true;
    }

}

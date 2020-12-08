package com.lordy.shop.shop_service.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Bean
    RedissonClient redisClient() throws Exception{
        Config config = new Config();
        config.useSingleServer().setAddress("localhost:6379");
        return Redisson.create(config);
    }
}

package com.lordy.user.user_service.service;

import com.lordy.user.user_api.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String str) {
        return "Hello " + str;
    }
}

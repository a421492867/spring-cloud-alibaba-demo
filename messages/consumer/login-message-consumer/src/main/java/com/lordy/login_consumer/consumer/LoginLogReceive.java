package com.lordy.login_consumer.consumer;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lordy.log.log_api.api.LoginLogService;
import com.lordy.log.log_api.entity.LoginLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class LoginLogReceive {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private LoginLogService loginLogService;

    @StreamListener("login-log-topic")
    public void receiveLoginLog(String loginLogJson){
        logger.info(loginLogJson);
        LoginLog loginLog = JSON.parseObject(loginLogJson, LoginLog.class);
        loginLogService.insertLoginLog(loginLog);
    }
}

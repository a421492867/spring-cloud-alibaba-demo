package com.lordy.login_producer.producer;

import com.lordy.log.log_api.api.LoginLogService;
import com.lordy.log.log_api.entity.LoginLog;
import com.lordy.login_producer.message.LoginLogMessageProducerSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginLogMessageProducer{

    @Resource
    private LoginLogMessageProducerSource loginLogMessageProducerSource;

    public boolean sendLoginLog(LoginLog loginLog){
        return loginLogMessageProducerSource.loginLog().send(MessageBuilder.withPayload(loginLog).build());
    }

}

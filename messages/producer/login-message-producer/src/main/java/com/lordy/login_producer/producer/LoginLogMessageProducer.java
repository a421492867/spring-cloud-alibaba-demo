package com.lordy.login_producer.producer;

import com.lordy.log.log_api.api.LoginLogService;
import com.lordy.log.log_api.entity.LoginLog;
import com.lordy.login_producer.message.LoginLogMessageProducerSource;
import com.lordy.messages.producer_api.login_producer_api.service.LoginProducerService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@Service
public class LoginLogMessageProducer implements LoginProducerService {

    @Resource
    private LoginLogMessageProducerSource loginLogMessageProducerSource;

    public boolean sendLoginLog(LoginLog loginLog){
        return loginLogMessageProducerSource.loginLog().send(MessageBuilder.withPayload(loginLog).build());
    }

}

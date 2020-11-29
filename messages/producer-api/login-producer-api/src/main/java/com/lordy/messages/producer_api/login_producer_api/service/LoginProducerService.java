package com.lordy.messages.producer_api.login_producer_api.service;

import com.lordy.log.log_api.entity.LoginLog;

public interface LoginProducerService {

    public boolean sendLoginLog(LoginLog loginLog);
}

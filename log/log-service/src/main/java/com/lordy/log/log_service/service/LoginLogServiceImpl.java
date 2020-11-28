package com.lordy.log.log_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.log.log_api.api.LoginLogService;
import com.lordy.log.log_api.entity.LoginLog;
import com.lordy.log.log_service.mapper.LoginLogMapper;
import org.apache.dubbo.config.annotation.Service;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    @Override
    public boolean insertLoginLog(LoginLog loginLog) {
        return insert(loginLog);
    }
}

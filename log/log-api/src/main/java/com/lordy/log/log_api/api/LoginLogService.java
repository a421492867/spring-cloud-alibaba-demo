package com.lordy.log.log_api.api;

import com.lordy.log.log_api.entity.LoginLog;

public interface LoginLogService {

    boolean insertLoginLog(LoginLog loginLog);
}

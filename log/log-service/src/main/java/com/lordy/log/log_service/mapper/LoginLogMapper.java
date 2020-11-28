package com.lordy.log.log_service.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lordy.log.log_api.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}

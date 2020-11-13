package com.lordy.user.user_service.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lordy.user.user_api.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

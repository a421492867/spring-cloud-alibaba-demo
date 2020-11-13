package com.lordy.user.user_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.User;
import com.lordy.user.user_service.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

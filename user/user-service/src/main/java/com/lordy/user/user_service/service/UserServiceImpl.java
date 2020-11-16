package com.lordy.user.user_service.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.User;
import com.lordy.user.user_api.entity.UserRole;
import com.lordy.user.user_service.mapper.UserMapper;
import com.lordy.user.user_service.mapper.UserRoleMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public boolean insertUser(RegisterDto registerDto) {
        User user = registerDto.getUser();
        String username = user.getUsername();
        if(isExist(username)){
            return false;
        }
        insert(user);
        Integer userId = user.getId();
        Integer roleId = registerDto.getRoleId();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return userRoleMapper.insert(userRole) > 0;
    }


    public boolean isExist(String username){
        Wrapper w = new EntityWrapper();
        w.eq("username", username);
        User user = selectOne(w);
        return user != null;
    }
}

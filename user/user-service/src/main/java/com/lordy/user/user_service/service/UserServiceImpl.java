package com.lordy.user.user_service.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.commons.database.config.CommonConfig;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.*;
import com.lordy.user.user_service.mapper.RoleMapper;
import com.lordy.user.user_service.mapper.UserMapper;
import com.lordy.user.user_service.mapper.UserRoleMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    @Transactional
    public boolean insertUser(RegisterDto registerDto) {
        User user = registerDto.getUser();
        String username = user.getUsername();
        if(isExist(username)){
            return false;
        }

        //todo 密码加密
//        String password = user.getPassword();
//        user.setPassword();

        user.setStatus(CommonConfig.IN_USE_STATUS);
        user.setCreateTime(CommonConfig.sdf.format(new Date()));
        insert(user);
        Integer userId = user.getId();
        Integer roleId = registerDto.getRoleId();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return userRoleMapper.insert(userRole) > 0;
    }

    @Override
    @Transactional
    public boolean deleteUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setStatus(CommonConfig.DELETED_STATUS);
        updateById(user);
        Wrapper<UserRole> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id", id);
        return userRoleMapper.delete(wrapper) > 0;
    }

    @Override
    public UserDto getUserDtoByUsername(String username){
        Wrapper wrapper = new EntityWrapper();
        wrapper.eq("username", username);
        User user = selectOne(wrapper);
        if(user == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        Wrapper<UserRole> userRoleWrapper = new EntityWrapper<>();
        userRoleWrapper.eq("user_id", user.getId());
        List<UserRole> userRoleList = userRoleMapper.selectList(userRoleWrapper);
        if(userRoleList == null || userRoleList.isEmpty()){
            return userDto;
        }
        String[] authorities = new String[userRoleList.size()];
        for(int i = 0; i < userRoleList.size(); i++){
            Role role = roleMapper.selectById(userRoleList.get(i).getRoleId());
            authorities[i] = role.getRoleName();
        }

        userDto.setAuthorities(authorities);
        return userDto;
    }

    public boolean isExist(String username){
        Wrapper w = new EntityWrapper();
        w.eq("username", username);
        User user = selectOne(w);
        return user != null;
    }
}

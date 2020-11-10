package com.lordy.uaa.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.uaa.entity.User;
import com.lordy.uaa.mapper.UserMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Wrapper wrapper = new EntityWrapper();
        wrapper.eq("username", s);
        User user = selectOne(wrapper);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole())
            );
        }else {
            throw new UsernameNotFoundException("用户[" + s + "] 不存在");
        }
    }
}

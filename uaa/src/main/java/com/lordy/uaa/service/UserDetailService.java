package com.lordy.uaa.service;

import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {


    @Reference
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDto userDto = userService.getUserDtoByUsername(s);
        if(userDto != null){
            return new org.springframework.security.core.userdetails.User(
                    userDto.getUser().getUsername(), userDto.getUser().getPassword(), AuthorityUtils.createAuthorityList(userDto.getAuthorities())
            );
        }else {
            throw new UsernameNotFoundException("用户[" + s + "] 不存在");
        }
    }
}

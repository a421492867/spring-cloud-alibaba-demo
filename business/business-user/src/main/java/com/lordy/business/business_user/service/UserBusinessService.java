package com.lordy.business.business_user.service;

import com.lordy.commons.web.api.Response;
import com.lordy.user.user_api.api.RoleService;
import com.lordy.user.user_api.api.UserRoleService;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.Role;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {

    @Reference
    private UserService userService;

    public Response register(RegisterDto registerDto){
        if(userService.insertUser(registerDto)){
            return Response.success();
        }
        return Response.error();
    }

    public Response deleteOne(Integer id){
        if(userService.deleteUser(id)){
            return Response.success();
        }
        return Response.error();
    }


}

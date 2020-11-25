package com.lordy.business.business_user.service;

import com.lordy.commons.web.api.Response;
import com.lordy.user.user_api.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserBussinessService {

    @Reference
    private UserService userService;

    public Response deleteUser(Integer id){
        if(userService.deleteUser(id)){
            return Response.success();
        }
        return Response.error();
    }


}

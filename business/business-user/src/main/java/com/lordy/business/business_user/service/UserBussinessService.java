package com.lordy.business.business_user.service;

import com.lordy.commons.web.api.Response;
import com.lordy.user.user_api.api.AvatarService;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.Avatar;
import com.lordy.user.user_api.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserBussinessService {

    @Reference
    private UserService userService;

    @Reference
    private AvatarService avatarService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String INITIAL_PASSWORD = "123456";

    public Response updateUserInfo(User user){
        if(userService.updateUserInfo(user)){
            return Response.success();
        }
        return Response.error();
    }

    public Response info(String username){
        return Response.dataSuccess(userService.getUserInfoByUsername(username));
    }

    public Response deleteUser(Integer id){
        if(userService.deleteUser(id)){
            return Response.success();
        }
        return Response.error();
    }

    public Response updateAvatar(MultipartFile file, int avatarId){
        if(avatarService.insertOrUpdateAvatar(file, avatarId) > 0){
            return Response.success();
        }
        return Response.error();
    }

    public Avatar getAvatar(Integer avatarId){
        Avatar avatar = avatarService.getAvatarById(avatarId);
        return avatar;
    }

    public Response modifyPassword(String old, String newPassword, String username){
        User user = userService.getUserInfoByUsername(username);
        String password = user.getPassword();
        if(!passwordEncoder.matches(old, password)){
            return new Response(500, "原密码不正确", null);
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        if(!userService.updateUserInfo(user)){
            return Response.error();
        }
        return Response.success();
    }

    public Response resetPassword(String username){
        User user = userService.getUserInfoByUsername(username);
        user.setPassword(passwordEncoder.encode(INITIAL_PASSWORD));
        if(userService.updateUserInfo(user)){
            return Response.dataSuccess(INITIAL_PASSWORD);
        }
        return Response.error();
    }


}

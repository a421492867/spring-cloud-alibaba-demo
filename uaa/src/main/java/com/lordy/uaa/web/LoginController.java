package com.lordy.uaa.web;

import com.alibaba.fastjson.JSON;
import com.lordy.commons.web.api.Response;
import com.lordy.uaa.service.UserDetailService;
import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserDetailService userDetailService;


    @PostMapping("/register")
    public Response register(@RequestBody RegisterDto registerDto){
        return userDetailService.register(registerDto);
    }

    @PostMapping("login")
    public Response login(@RequestParam String username, @RequestParam String password){
        return Response.dataSuccess(username);
    }

    @GetMapping("/me")
    public Response currentUser(Principal principal){
        return Response.dataSuccess(principal);
    }

}

package com.lordy.business.business_user.web;

import com.lordy.business.business_user.service.UserBusinessService;
import com.lordy.commons.web.api.Response;
import com.lordy.user.user_api.entity.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserBusinessService userBusinessService;

    @PutMapping
    public Response register(@RequestBody RegisterDto registerDto){
        return userBusinessService.register(registerDto);
    }

    @DeleteMapping("{id}")
    public Response deleteOne(@PathVariable Integer id){
        return userBusinessService.deleteOne(id);
    }


}

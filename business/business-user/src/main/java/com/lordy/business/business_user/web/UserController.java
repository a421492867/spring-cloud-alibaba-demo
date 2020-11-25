package com.lordy.business.business_user.web;

import com.lordy.business.business_user.service.UserBussinessService;
import com.lordy.commons.web.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserBussinessService userBussinessService;

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("{id}")
    public Response deleteUser(@PathVariable Integer id){
        return userBussinessService.deleteUser(id);
    }


}

package com.lordy.business.business_user.web;

import com.lordy.business.business_user.service.RoleBusinessService;
import com.lordy.commons.web.api.Response;
import com.lordy.commons.web.api.SearchDto;
import com.lordy.user.user_api.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleBusinessService roleBusinessService;

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping
    public Response add(@RequestBody Role role){
        return roleBusinessService.addRole(role);
    }

    //hasRole需要前缀ROLE_
    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("{id}")
    public Response deleteOne(@PathVariable Integer id){
        return roleBusinessService.deleteRole(id);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("{id}")
    public Response getOne(@PathVariable Integer id){
        return roleBusinessService.getOne(id);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("list")
    public Response list(@RequestBody SearchDto searchDto){
        return roleBusinessService.list(searchDto);
    }
}

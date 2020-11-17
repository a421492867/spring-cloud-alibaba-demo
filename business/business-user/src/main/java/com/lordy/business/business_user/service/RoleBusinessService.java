package com.lordy.business.business_user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lordy.commons.web.api.Response;
import com.lordy.commons.web.api.SearchDto;
import com.lordy.user.user_api.api.RoleService;
import com.lordy.user.user_api.entity.Role;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleBusinessService {

    @Reference
    private RoleService roleService;

    public Response getOne(Integer id){
        return Response.dataSuccess(roleService.getOne(id));
    }

    public Response addRole(Role role){
        if(roleService.addRole(role)){
            return Response.success();
        }
        return Response.error();
    }

    public Response deleteRole(Integer id){
        if(roleService.deleteRole(id)){
            return Response.success();
        }
        return Response.error();
    }

    public Response list(SearchDto searchDto){
        PageHelper.startPage(searchDto.getPage(), searchDto.getSize());
        List<Role> roleList = roleService.list(searchDto);
        PageInfo pageInfo = new PageInfo(roleList);
        return Response.dataSuccess(pageInfo);
    }
}

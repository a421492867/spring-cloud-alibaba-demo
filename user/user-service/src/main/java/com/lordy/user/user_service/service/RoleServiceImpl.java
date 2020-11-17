package com.lordy.user.user_service.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.commons.database.config.CommonConfig;
import com.lordy.commons.web.api.SearchDto;
import com.lordy.user.user_api.api.RoleService;
import com.lordy.user.user_api.entity.Role;
import com.lordy.user.user_service.mapper.RoleMapper;
import org.apache.dubbo.config.annotation.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public boolean addRole(Role role) {
        role.setCreateTime(CommonConfig.sdf.format(new Date()));
        role.setStatus(CommonConfig.IN_USE_STATUS);
        return insert(role);
    }

    @Override
    public boolean deleteRole(Integer id) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(CommonConfig.DELETED_STATUS);
        return updateById(role);
    }

    @Override
    public List<Role> list(SearchDto searchDto) {
        //PageHelper.startPage(searchDto.getPage(), searchDto.getSize());
        Wrapper w = new EntityWrapper();
        if(searchDto.getRoleName() != null && !"".equals(searchDto.getRoleName())){
            w.eq("role_name", searchDto.getRoleName());
        }
        w.eq("status", CommonConfig.IN_USE_STATUS);
        List<Role> roleList = selectList(w);
        //PageInfo pageInfo = new PageInfo(roleList);
        return roleList;
    }

    @Override
    public Role getOne(Integer id) {
        return selectById(id);
    }
}

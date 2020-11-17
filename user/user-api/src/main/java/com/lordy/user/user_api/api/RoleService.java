package com.lordy.user.user_api.api;

import com.lordy.commons.web.api.Response;
import com.lordy.commons.web.api.SearchDto;
import com.lordy.user.user_api.entity.Role;

import java.util.List;

public interface RoleService {

    boolean addRole(Role role);

    boolean deleteRole(Integer id);

    List<Role> list(SearchDto searchDto);

    Role getOne(Integer id);
}

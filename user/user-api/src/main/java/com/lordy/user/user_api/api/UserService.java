package com.lordy.user.user_api.api;

import com.github.pagehelper.PageInfo;
import com.lordy.commons.web.api.SearchDto;
import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.User;
import com.lordy.user.user_api.entity.UserDto;

public interface UserService {

    boolean insertUser(RegisterDto registerDto);

    boolean deleteUser(Integer id);

    UserDto getUserDtoByUsername(String username);

    User getUserInfoByUsername(String username);

    boolean updateUserInfo(User user);

    boolean modifyPassword(String old, String newPassword, String username);

    PageInfo<User> list(SearchDto searchDto);
}

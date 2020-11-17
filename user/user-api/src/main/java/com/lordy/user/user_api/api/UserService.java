package com.lordy.user.user_api.api;

import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.UserDto;

public interface UserService {

    boolean insertUser(RegisterDto registerDto);

    boolean deleteUser(Integer id);

    UserDto getUserDtoByUsername(String username);
}

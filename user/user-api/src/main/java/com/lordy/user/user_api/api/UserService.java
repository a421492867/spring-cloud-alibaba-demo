package com.lordy.user.user_api.api;

import com.lordy.user.user_api.entity.RegisterDto;

public interface UserService {

    boolean insertUser(RegisterDto registerDto);
}

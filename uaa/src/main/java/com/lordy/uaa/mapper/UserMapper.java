package com.lordy.uaa.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lordy.uaa.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

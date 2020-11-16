package com.lordy.user.user_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.user.user_api.api.AvatarService;
import com.lordy.user.user_api.entity.Avatar;
import com.lordy.user.user_service.mapper.AvatarMapper;
import org.apache.dubbo.config.annotation.Service;

@Service
public class AvatarServiceImpl extends ServiceImpl<AvatarMapper, Avatar> implements AvatarService {
}

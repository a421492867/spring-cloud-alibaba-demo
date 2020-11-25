package com.lordy.user.user_service.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lordy.commons.database.config.CommonConfig;
import com.lordy.user.user_api.api.AvatarService;
import com.lordy.user.user_api.entity.Avatar;
import com.lordy.user.user_service.mapper.AvatarMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class AvatarServiceImpl extends ServiceImpl<AvatarMapper, Avatar> implements AvatarService {
    @Override
    public int insertOrUpdateAvatar(MultipartFile file, Integer avatarId) {
        if(file.getSize() < 0){
            return -1;
        }
        byte[] bytes;
        try {
            bytes = file.getBytes();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        if(avatarId <= 0){
            Avatar avatar = new Avatar();
            avatar.setImg(bytes);
            avatar.setCreateTime(CommonConfig.sdf.format(new Date()));
            avatar.setStatus(CommonConfig.IN_USE_STATUS);
            insert(avatar);
            return avatar.getId();
        }else {
            Avatar avatar = selectById(avatarId);
            avatar.setImg(bytes);
            avatar.setUpdateTime(CommonConfig.sdf.format(new Date()));
            updateById(avatar);
            return avatarId;
        }

    }

    @Override
    public boolean deleteAvatar(Integer id) {
        return deleteById(id);
    }

    @Override
    public Avatar getAvatarById(Integer id) {
        return selectById(id);
    }
}

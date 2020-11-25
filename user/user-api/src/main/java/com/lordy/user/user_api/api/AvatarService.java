package com.lordy.user.user_api.api;

import com.lordy.user.user_api.entity.Avatar;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {

    int insertOrUpdateAvatar(MultipartFile file, Integer avatarId);

    boolean deleteAvatar(Integer id);

    Avatar getAvatarById(Integer id);
}

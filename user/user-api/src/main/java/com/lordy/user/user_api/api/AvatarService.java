package com.lordy.user.user_api.api;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {

    int insertOrUpdateAvatar(MultipartFile file, Integer avatarId);

    boolean deleteAvatar(Integer id);
}

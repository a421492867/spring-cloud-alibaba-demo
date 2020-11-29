package com.lordy.uaa.service;

import com.lordy.commons.database.config.CommonConfig;
import com.lordy.commons.web.api.Response;
import com.lordy.log.log_api.api.LoginLogService;
import com.lordy.log.log_api.entity.LoginLog;
import com.lordy.uaa.util.UserAgentUtil;
import com.lordy.user.user_api.api.AvatarService;
import com.lordy.user.user_api.api.UserService;
import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.User;
import com.lordy.user.user_api.entity.UserDto;
import eu.bitwalker.useragentutils.Browser;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserDetailService implements UserDetailsService {


    @Reference
    private UserService userService;

    @Reference
    private AvatarService avatarService;

    @Reference
    private LoginLogService loginLogService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean sendLoginLog(String username, HttpServletRequest request){
        LoginLog loginLog = new LoginLog();
        User user = userService.getUserInfoByUsername(username);
        Integer userId = user.getId();
        Browser browser = UserAgentUtil.getBrowser(request);
        String ip = UserAgentUtil.getIpAddr(request);
        loginLog.setUserAgent(browser.getName());
        loginLog.setIp(ip);
        loginLog.setCreateTime(CommonConfig.sdf.format(new Date()));
        loginLog.setStatus(CommonConfig.IN_USE_STATUS);
        loginLog.setUserId(userId);
        return loginLogService.insertLoginLog(loginLog);
    }

    public Response uploadAvatar(MultipartFile file){
        int avatarId = avatarService.insertOrUpdateAvatar(file, -1);
        if(avatarId > 0){
            return Response.dataSuccess(avatarId);
        }
        return Response.error();
    }

    public Response register(RegisterDto registerDto){
        User user = registerDto.getUser();
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        registerDto.setUser(user);
        if(userService.insertUser(registerDto)){
            return Response.success();
        }
        return Response.error();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDto userDto = userService.getUserDtoByUsername(s);
        if(userDto != null){
            return new org.springframework.security.core.userdetails.User(
                    userDto.getUser().getUsername(), userDto.getUser().getPassword(), AuthorityUtils.createAuthorityList(userDto.getAuthorities())
            );
        }else {
            throw new UsernameNotFoundException("用户[" + s + "] 不存在");
        }
    }
}

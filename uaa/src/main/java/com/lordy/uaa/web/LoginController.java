package com.lordy.uaa.web;

import com.alibaba.fastjson.JSON;
import com.lordy.commons.web.api.Response;
import com.lordy.uaa.service.UserDetailService;
import com.lordy.uaa.util.HttpUtil;
import com.lordy.user.user_api.entity.RegisterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @Value("${grant_type}")
    private String grantType;

    @Value("${client_id}")
    private String clientId;

    @Value("${client_secret}")
    private String clientSecret;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/upload_avatar")
    public Response uploadAvatar(@RequestParam("file") MultipartFile file){
        return userDetailService.uploadAvatar(file);
    }

    @PostMapping("/register")
    public Response register(@RequestBody RegisterDto registerDto){
        return userDetailService.register(registerDto);
    }

    @PostMapping("login")
    public Response login(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if(userDetails == null){
            return new Response(500, "用户不存在", null);
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            return new Response(500, "密码错误", null);
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("grant_type", grantType);
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        String res = HttpUtil.doPost(URL_OAUTH_TOKEN, params, "utf8", true);
        logger.info(res);
        userDetailService.sendLoginLog(username, request);
        return Response.dataSuccess(JSON.parse(res));
    }

    @PostMapping("logout")
    public Response logout(@RequestParam("token") String token){
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return Response.success();
    }

    @GetMapping("/me")
    public Response currentUser(Principal principal){
        return Response.dataSuccess(principal);
    }




}

package com.lordy.business.business_user.web;

import com.lordy.business.business_user.service.UserBussinessService;
import com.lordy.commons.web.api.Response;
import com.lordy.commons.web.api.SearchDto;
import com.lordy.user.user_api.entity.Avatar;
import com.lordy.user.user_api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserBussinessService userBussinessService;

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("{id}")
    public Response deleteUser(@PathVariable Integer id){
        return userBussinessService.deleteUser(id);
    }

    //@PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @PostMapping("update_avatar")
    public Response updateAvatar(@RequestParam("file") MultipartFile file, @RequestParam("avatarId") int avatarId){
        return userBussinessService.updateAvatar(file, avatarId);
    }

    //@PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @PostMapping("update_info")
    public Response updateInfo(@RequestBody User user){
        return userBussinessService.updateUserInfo(user);
    }

    //@PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @GetMapping("{username}")
    public Response myInfo(@PathVariable String username){
        return userBussinessService.info(username);
    }

    //@PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @GetMapping("avatar/{avatarId}")
    public void myAvatar(@PathVariable Integer avatarId, HttpServletResponse response) throws Exception{
        if(avatarId == null){
            return;
        }
        Avatar avatar = userBussinessService.getAvatar(avatarId);
        if(avatar == null){
            return;
        }
        byte[] bytes = avatar.getImg();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.close();
    }

    //@PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @PostMapping("modify_password")
    public Response modifyPassword(@RequestParam("old_pass") String old, @RequestParam("new_pass") String newPass, @RequestParam("username") String username){
        return userBussinessService.modifyPassword(old, newPass, username);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("reset_password/{username}")
    public Response resetPassword(@PathVariable String username){
        return userBussinessService.resetPassword(username);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("list")
    public Response list(@RequestBody SearchDto searchDto){
        return userBussinessService.list(searchDto);
    }


}

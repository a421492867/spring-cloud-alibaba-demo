package com.lordy.user.user_api.entity;

import java.io.Serializable;

public class RegisterDto implements Serializable {

    private User user;

    private Integer roleId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

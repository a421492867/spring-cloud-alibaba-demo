package com.lordy.user.user_api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.lordy.commons.database.entity.BaseEntity;

@TableName("role")
public class Role extends BaseEntity {

    @TableField
    private String roleName;

    @TableField
    private String remark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

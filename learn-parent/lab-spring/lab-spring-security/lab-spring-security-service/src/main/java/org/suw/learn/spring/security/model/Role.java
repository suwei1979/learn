/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

/**
 * @classname: Role
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 4:00 PM
 * @modified
 **/
@Data
public class Role implements GrantedAuthority {

    public static final Role ROLE_ADMIN = new Role(Long.valueOf(001), "ROLE_ADMIN");
    public static final Role ROLE_USER = new Role(Long.valueOf(002), "ROLE_USER");

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    private Long roleId;

    private String roleName;

    private String description;

    @Override
    public String getAuthority() {
        return roleName;
    }
}

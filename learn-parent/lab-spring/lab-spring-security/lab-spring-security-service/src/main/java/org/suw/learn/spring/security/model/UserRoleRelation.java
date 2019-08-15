/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Data;

/**
 * @classname: UserRoleRelation
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 5:57 PM
 * @modified
 **/
@Data
public class UserRoleRelation {
    private static final AtomicLong keyGenerator = new AtomicLong();
    private final User user;
    private final List<Role> roles;
    private Long relationId;

    public UserRoleRelation(User user, List<Role> roles) {
        this.user = user;
        this.roles = roles;
        this.relationId = keyGenerator.getAndIncrement();
    }


    public UserRoleRelation(User user, Role role) {
        this.relationId = keyGenerator.getAndIncrement();
        this.user = user;
        this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

}

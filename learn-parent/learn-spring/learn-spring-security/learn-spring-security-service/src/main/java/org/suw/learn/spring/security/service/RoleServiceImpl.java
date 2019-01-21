/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.security.model.Role;
import org.suw.learn.spring.security.model.UserRoleRelation;
import org.suw.learn.spring.security.model.support.RoleHelper;

/**
 * @classname: RoleServiceImpl
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 4:01 PM
 * @modified
 **/
@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleHelper roleHelper;
    private static List<Role> roles;
    private static Map<Long, UserRoleRelation> roleUserRelations;

    static {
        roles = populateDummyRoles();
    }


    private static List<Role> populateDummyRoles() {
        List<Role> result = new ArrayList<>();
        result.add(Role.ROLE_ADMIN);
        result.add(Role.ROLE_USER);
        return result;
    }

    @Override
    public void addRole(Long userId, Role role) {
//        UserRoleRelation userRoleRelation = roleHelper.buildRoleUserRelation(userId, role);
//        roleUserRelations.put(userId, userRoleRelation);
    }

    @Override
    public void addRoles(Long userId, List<Role> roles) {
//        UserRoleRelation userRoleRelation = roleHelper.buildRoleUserRelation(userId, roles);
//        roleUserRelations.put(userId, userRoleRelation);
    }

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        return roleUserRelations.get(userId).getRoles();
    }
}

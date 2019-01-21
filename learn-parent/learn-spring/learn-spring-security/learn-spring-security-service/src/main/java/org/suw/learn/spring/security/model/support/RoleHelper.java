/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.model.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.security.exception.UserNotExistException;
import org.suw.learn.spring.security.model.Role;
import org.suw.learn.spring.security.model.UserRoleRelation;
import org.suw.learn.spring.security.model.User;
import org.suw.learn.spring.security.service.RoleService;
import org.suw.learn.spring.security.service.UserService;

/**
 * @classname: RoleHelper
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 6:38 PM
 * @modified
 **/
@Component
public class RoleHelper implements InitializingBean {
    private static List<UserRoleRelation> relations = new ArrayList<>();
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    RoleService roleService;

    @Autowired
    UserHelper userHelper;

//    public UserRoleRelation buildRoleUserRelation(Long userId, Role role) throws UserNotExistException {
//        User user = buildUser(userId);
//        return new UserRoleRelation(user, role);
//    }
//
//    public UserRoleRelation buildRoleUserRelation(Long userId, List<Role> roles) {
//        User user = buildUser(userId);
//        return new UserRoleRelation(user, roles);
//    }
//
//
//    public User buildUser(Long userId) {
//        User user = userService.getUserById(userId);
//        if (userId == null) {
//            throw new UserNotExistException("User not exists");
//        }
//        return user;
//    }
//
    @Override
    public void afterPropertiesSet() throws Exception {
        List<User> users = userHelper.users;
        Random random = new Random();
        int adminNum = random.nextInt(users.size());
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (i == adminNum) {
                System.out.println(user + " has been granted authority of " + Role.ROLE_ADMIN);
//                relations.add(new UserRoleRelation(user, Arrays.asList(RoleServiceImpl.ROLE_ADMIN)));
                user.addRole(Role.ROLE_ADMIN);
            } else {
                System.out.println(user + " has been granted authority of " + Role.ROLE_USER);
//                relations.add(new UserRoleRelation(user, Arrays.asList(Role.ROLE_USER)));
                user.addRole(Role.ROLE_USER);
            }
        }
    }
}

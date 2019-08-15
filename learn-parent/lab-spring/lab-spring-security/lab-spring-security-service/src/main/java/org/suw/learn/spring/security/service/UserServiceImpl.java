/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.security.model.User;
import org.suw.learn.spring.security.model.support.UserHelper;

/**
 * @classname: UserServiceImpl
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 1:58 PM
 * @modified
 **/
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User result = UserHelper.users.stream().filter(user -> s.equals(user.getUsername())).findAny().get();
        return result;
    }

    @Override
    public List<User> findAllUsers() {
        return UserHelper.users;
    }

    @Override
    public User getUserById(Long id) {
        return UserHelper.users.stream().filter(user -> id.equals(user.getId())).findAny().get();
    }

    @Override
    public boolean isUserExist(User user) {
        return loadUserByUsername(user.getUsername()) != null;
    }

    @Override
    public void saveUser(User user) {
        user.setId(UserHelper.counter.incrementAndGet());
        UserHelper.users.add(user);
    }

    @Override
    public void deleteAllUsers() {
        UserHelper.users.clear();
    }

    @Override
    public void deleteUserById(Long id) {
        for (Iterator<User> iterator = UserHelper.users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }
}

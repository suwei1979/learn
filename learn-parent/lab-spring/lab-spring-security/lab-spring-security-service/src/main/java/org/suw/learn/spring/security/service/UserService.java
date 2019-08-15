/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.suw.learn.spring.security.model.User;

public interface UserService extends UserDetailsService {
    List<User> findAllUsers();

    User getUserById(Long id);

    boolean isUserExist(User user);

    void saveUser(User user);

    void deleteUserById(Long id);

    void deleteAllUsers();


}

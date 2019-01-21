/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.service;

import java.util.List;

import org.suw.learn.spring.security.model.Role;

public interface AuthorityService {
    void authorize(Long userId, List<Role> roles);

    void authorize(Long userId, Role role);
}

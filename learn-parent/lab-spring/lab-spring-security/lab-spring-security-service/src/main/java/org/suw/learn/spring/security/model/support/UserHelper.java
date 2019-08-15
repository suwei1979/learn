/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.model.support;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.suw.learn.spring.security.model.User;

/**
 * @classname: UserHelper
 * @author: suwei
 * @description:
 * @date: created in 2018/12/19 : 3:55 PM
 * @modified
 **/
@Component
public class UserHelper implements InitializingBean {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static final AtomicLong counter = new AtomicLong();
    public static List<User> users;

    @Override
    public void afterPropertiesSet() throws Exception {
        users = new ArrayList<>();
        User sam = new User(counter.incrementAndGet(), "Sam", passwordEncoder.encode("Sam"), 30, BigDecimal.valueOf(70000, 2));
        User tom = new User(counter.incrementAndGet(), "Tom", passwordEncoder.encode("Tom"), 40, BigDecimal.valueOf(50000, 2));
        User jerome = new User(counter.incrementAndGet(), "Jerome", passwordEncoder.encode("Jerome"), 45, BigDecimal.valueOf(30000, 2));
        User silvia = new User(counter.incrementAndGet(), "Silvia", passwordEncoder.encode("Silvia"), 50, BigDecimal.valueOf(40000, 2));
        users.add(sam);
        users.add(tom);
        users.add(jerome);
        users.add(silvia);
        Collections.unmodifiableList(users);

    }
}

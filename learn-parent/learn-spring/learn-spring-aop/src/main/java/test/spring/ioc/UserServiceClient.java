/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.ioc;

import test.spring.ioc.business.User;

public class UserServiceClient {
    public void createUser() {
        User user = new User();
        user.setUserId("USER0001");
        user.setPassword("******");
        user.setPhone("66587276");
        user.setMobile("13800138000");
        user.setAddress("Washington DC, Queen Street.");
        user.save();
    }
}

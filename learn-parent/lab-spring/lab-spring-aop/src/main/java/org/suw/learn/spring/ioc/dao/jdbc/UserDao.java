/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.ioc.dao.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.suw.learn.spring.ioc.business.User;
import org.suw.learn.spring.ioc.dao.IUserDao;

public class UserDao extends JdbcDaoSupport implements IUserDao {

    public void createUser(User user) {
        getJdbcTemplate().execute(
                "insert into t_user (" + " user_id, " + " user_name," + " user_pwd," + " address," + " phone,"
                        + " mobile" + ") values ( " + " '" + user.getUserId() + "'" + " '" + user.getUserName() + "'"
                        + " '" + user.getPassword() + "'" + " '" + user.getAddress() + "'" + " '" + user.getPhone()
                        + "'" + " '" + user.getMobile() + "'" + ") ");

    }
}

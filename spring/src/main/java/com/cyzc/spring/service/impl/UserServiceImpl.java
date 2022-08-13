package com.cyzc.spring.service.impl;

import com.cyzc.spring.dao.UserDao;
import com.cyzc.spring.service.UserService;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/30 07:53]
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

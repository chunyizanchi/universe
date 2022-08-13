package com.cyzc.spring.factory;

import com.cyzc.spring.bean.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 13:41]
 */
public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login(String userName, String password) {
        System.out.println("UserServiceImpl.login");
    }
}

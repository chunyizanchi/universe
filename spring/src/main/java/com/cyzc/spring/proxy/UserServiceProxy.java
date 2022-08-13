package com.cyzc.spring.proxy;

import com.cyzc.spring.bean.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 07:55]
 */
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("UserServiceProxy.register");
        userService.register(user);
    }

    @Override
    public boolean login(String userName, String password) {
        System.out.println("UserServiceProxy.login");
        userService.login(userName, password);
        return false;
    }
}

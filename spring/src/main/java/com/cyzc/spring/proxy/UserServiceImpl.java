package com.cyzc.spring.proxy;

import com.cyzc.spring.annotation.Log;
import com.cyzc.spring.bean.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 07:51]
 */
public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算+dao");
    }

    @Override
    @Log
    public boolean login(String userName, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}

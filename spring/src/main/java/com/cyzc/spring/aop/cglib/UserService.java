package com.cyzc.spring.aop.cglib;

import com.cyzc.spring.bean.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 08:11]
 */
public class UserService {


    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算+dao");
    }


    public boolean login(String userName, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}

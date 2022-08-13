package com.cyzc.spring.aopdev;

import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 16:32]
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void register() {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login() {
        System.out.println("UserServiceImpl.login");
    }
}

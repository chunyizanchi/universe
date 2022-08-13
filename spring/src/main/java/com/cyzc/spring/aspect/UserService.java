package com.cyzc.spring.aspect;

import com.cyzc.spring.bean.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 13:40]
 */
public interface UserService {

    public void register(User user);

    public void login(String userName, String password);
}

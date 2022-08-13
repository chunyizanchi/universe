package com.cyzc.spring.proxy;

import com.cyzc.spring.bean.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 07:51]
 */
public interface UserService {

    public void register(User user);

    public boolean login(String userName,String password);
}

package com.cyzc.dubbo.service;

import com.cyzc.dubbo.domian.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 22:07]
 */
public interface UserService {

    void register(User user);

    User getUserById(Long id);
}

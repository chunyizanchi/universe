package com.cyzc.dubbo.service;

import com.cyzc.dubbo.domian.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 23:42]
 */
public interface LocalUserService {

    void register(User user);

    User getById(Long id);
}

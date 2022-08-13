package com.cyzc.spring.mybatis.service;

import com.cyzc.spring.mybatis.entity.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 22:46]
 */
public interface UserService {

    public void register(User user) throws Exception;

    public void login(String userName,String password);

}

package com.cyzc.dubbo.mapper.impl;

import com.cyzc.dubbo.domian.User;
import com.cyzc.dubbo.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 22:15]
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Override
    public void insert(User user) {
        System.out.println("数据库访问：新增用户 - " + user);
    }

    @Override
    public User selectById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("name" + id);
        user.setPassword("password" + id);
        System.out.println("数据库访问：主键查询用户 - " + user);
        return user;
    }
}

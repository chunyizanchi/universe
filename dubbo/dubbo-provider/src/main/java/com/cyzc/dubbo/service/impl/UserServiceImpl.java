package com.cyzc.dubbo.service.impl;

import com.cyzc.dubbo.domian.User;
import com.cyzc.dubbo.mapper.UserMapper;
import com.cyzc.dubbo.service.UserService;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 22:10]
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        System.out.println("注册用户成功");
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
}

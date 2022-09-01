package com.cyzc.dubbo.mapper;

import com.cyzc.dubbo.domian.User;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 22:09]
 */
public interface UserMapper {
    void insert(User user);
    User selectById(Long id);
}

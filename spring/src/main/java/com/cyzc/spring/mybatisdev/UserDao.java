package com.cyzc.spring.mybatisdev;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 17:28]
 */
@Mapper
public interface UserDao {

    public void save(User user);

}

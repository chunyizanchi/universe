package com.cyzc.spring.mybatis.service;

import com.cyzc.spring.mybatis.dao.UserDao;
import com.cyzc.spring.mybatis.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> @Transactional(isolation = REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly =
 * true, timeout = 10, rollbackFor = Exception.class,noRollbackFor = Exception.class)
 *
 * @author Cyzc
 * @since [2022/04/01 22:47]
 */
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void register(User user) throws Exception {

        userDao.save(user);
        throw new Exception("抛出异常");
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public void login(String userName, String password) {

    }
}

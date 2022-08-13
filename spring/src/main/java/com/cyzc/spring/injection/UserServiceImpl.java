package com.cyzc.spring.injection;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/02 18:23]
 */
@Service
public class UserServiceImpl implements UserService {

   // @Resource(lookup = "1231321")
    @Inject
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }


    public void setUserDao(UserDao userDao) {
        System.out.println("UserServiceImpl.setUserDao");
        this.userDao = userDao;
    }

    @Override
    public void register() {
        userDao.save();
    }
}

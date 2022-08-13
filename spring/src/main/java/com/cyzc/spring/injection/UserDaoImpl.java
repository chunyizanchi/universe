package com.cyzc.spring.injection;

import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/02 18:19]
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDaoImpl.save()");
    }

}

package com.cyzc.spring;

import com.cyzc.spring.mybatisdev.User;
import com.cyzc.spring.mybatisdev.UserDao;
import org.junit.Test;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 17:32]
 */
public class TestMybatisDev {

    @Test
    public void test1() {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                MybatisAutoConfiguration.class);
       /* UserDao userDao = (UserDao) annotationConfigApplicationContext.getBean("userDao");
        User user = new User();
        user.setName("TestMybatisDev");
        user.setPassword("123456");

        userDao.save(user);*/
    }

}

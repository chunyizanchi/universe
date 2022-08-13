package com.cyzc.spring;

import com.cyzc.spring.mybatis.dao.UserDao;
import com.cyzc.spring.mybatis.entity.User;
import com.cyzc.spring.mybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 22:26]
 */
public class TestMybatis {

    /**
     * 用于测试: Spring 与 Mybatis 的整合
     */
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext7.xml");
        UserDao userDAO = (UserDao) ctx.getBean("userDao");

        User user = new User();
        user.setName("1112312321");
        user.setPassword("999999");
        //Spring 采用durid 连接池，保持自动事务提交
        userDAO.save(user);
    }

    //测试事务
    @Test
    public void test1() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext7.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setName("测试事务抛出异常 回滚3");
        user.setPassword("999999");
        //Spring 采用durid 连接池，保持自动事务提交
        userService.register(user);

    }



}

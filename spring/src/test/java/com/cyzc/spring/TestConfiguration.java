package com.cyzc.spring;

import com.cyzc.spring.bean.Customer;
import com.cyzc.spring.bean.User;
import com.cyzc.spring.configuration.AppConfig;
import com.cyzc.spring.configuration.AppConfig1;
import com.cyzc.spring.configuration.AppConfig3;
import com.cyzc.spring.configuration.AppConfig4;
import com.cyzc.spring.configuration.AppConfig6;
import com.cyzc.spring.configuration.AppConfig7;
import com.cyzc.spring.injection.UserDao;
import com.cyzc.spring.injection.UserService;
import java.sql.Connection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/06 22:33]
 */
public class TestConfiguration {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                "com.cyzc.spring");*/
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                "com.cyzc.spring");*/
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                "com.cyzc.spring");*/
        Connection connection = (Connection) applicationContext.getBean("getConnection");
        System.out.println(connection);
    }

    /**
     * 测试对象创建次数
     *
     * @author cyzc
     * @since 2022/4/7 10:32
     */
    @Test
    public void test4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        User user = (User) applicationContext.getBean("userBean");
        User user1 = (User) applicationContext.getBean("userBean");
        System.out.println(user);
        System.out.println(user1);
    }

    /**
     * 测试注入复杂对象
     *
     * @author cyzc
     * @since 2022/4/7 10:32
     */
    @Test
    public void test5() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.register();
    }

    /**
     * @author cyzc
     * @since 2022/4/7 11:02
     */
    @Test
    public void test6() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        Customer customer = (Customer) applicationContext.getBean("customer");
        System.out.println(customer);
    }

    @Test
    public void test7() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig1.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test8() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig3.class);
        Customer customer = (Customer) applicationContext.getBean("customer");
        System.out.println(customer);
    }

    //测试解耦合
    @Test
    public void test9() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig4.class);
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }

    @Test
    public void tes10() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig6.class);
        UserService userDao = (UserService) applicationContext.getBean("userService");
        userDao.register();
    }

    /**
     *  @Component 和 配置bean的整合
     * @author cyzc
     * @since 2022/4/7 15:21
     */
    @Test
    public void tes11() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig7.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserDao userDaoImpl = (UserDao) applicationContext.getBean("userDaoImpl");

    }

    /**
     * 测试默认
     * @author cyzc
     * @param null
     * @return {@link }
     * @since 2022/4/7 15:37
     */
    @Test
    public void tes12() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        User userBean = (User) applicationContext.getBean("userBean");

    }
}
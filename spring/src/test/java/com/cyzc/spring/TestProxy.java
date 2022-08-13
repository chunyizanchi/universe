package com.cyzc.spring;

import com.cyzc.spring.bean.User;
import com.cyzc.spring.proxy.OrderService;
import com.cyzc.spring.proxy.UserService;
import com.cyzc.spring.proxy.UserServiceProxy;
import com.cyzc.spring.proxy.dynamic.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 08:02]
 */
public class TestProxy {

    /**
     * 用于测试静态代理
     *
     * @return {@link Void}
     * @author cyzc
     * @since 2022/3/31 8:02
     */
    @Test
    public void test1() {

        UserService userServiceProxy = new UserServiceProxy();
        userServiceProxy.login("admin", "123456");
        userServiceProxy.register(new User());

    }


    @Test
    public void test2() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext4.xml");
        Before before = (Before) context.getBean("before");
        System.out.println(before);
    }

    /**
     * 通过原始对象的 的getBea 获得的是代理对象
     *
     * @return {@link Void}
     * @author cyzc
     * @since 2022/3/31 14:23
     */
    @Test
    public void test3() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext4.xml");
        //java.lang.ClassCastException: com.sun.proxy.$Proxy6 cannot be cast to com.cyzc.spring.proxy.UserServiceImpl
        //UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        //代理对象使用 接口来接受
        UserService userService = (UserService) context.getBean("userService");
        userService.register(new User());
        userService.login("admin", "123456");
        System.out.println(userService);
    }

    @Test
    public void test4() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext4.xml");
        //java.lang.ClassCastException: com.sun.proxy.$Proxy6 cannot be cast to com.cyzc.spring.proxy.UserServiceImpl
        //UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        //代理对象使用 接口来接受
        UserService userService = (UserService) context.getBean("userService");
        userService.register(new User());
        boolean login = userService.login("admin", "123456");
        System.out.println("login:" + login);
    }

    @Test
    public void test5() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext4.xml");
        //java.lang.ClassCastException: com.sun.proxy.$Proxy6 cannot be cast to com.cyzc.spring.proxy.UserServiceImpl
        //UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        //代理对象使用 接口来接受
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.showOrder();

    }

}

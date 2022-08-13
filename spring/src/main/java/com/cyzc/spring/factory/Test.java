package com.cyzc.spring.factory;

import com.cyzc.spring.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 14:30]
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext5.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.register(new User());
        userService.login("gx", "970106");
    }

}

package com.cyzc.spring.aspect;

import com.cyzc.spring.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 15:23]
 */
public class TestAspectJProxy {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext6.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.login("gx","234131");
        userService.register(new User());
    }

}

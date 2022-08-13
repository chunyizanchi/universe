package com.cyzc.spring.configuration;

import com.cyzc.spring.injection.UserDao;
import com.cyzc.spring.injection.UserService;
import com.cyzc.spring.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 15:20]
 */
@Configuration
@ComponentScan(basePackages = "com.cyzc.spring.injection")
public class AppConfig7 {

    @Autowired
    private UserDao userDao;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);

        return userService;
    }
}

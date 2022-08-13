package com.cyzc.spring.configuration;

import com.cyzc.spring.injection.UserDao;
import com.cyzc.spring.injection.UserService;
import com.cyzc.spring.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 15:10]
 */
@Configuration
@Import(AppConfig4.class)
public class AppConfig6 {

    @Autowired
    private UserDao userDao;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        return userService;
    }
}

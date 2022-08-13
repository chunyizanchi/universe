package com.cyzc.spring.configuration;

import com.cyzc.spring.injection.UserDao;
import com.cyzc.spring.injection.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 11:54]
 */
@Configuration
public class AppConfig4 {

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }
}

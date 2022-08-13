package com.cyzc.spring.configuration;

import com.cyzc.spring.bean.Customer;
import com.cyzc.spring.bean.User;
import com.cyzc.spring.injection.UserDao;
import com.cyzc.spring.injection.UserDaoImpl;
import com.cyzc.spring.injection.UserService;
import com.cyzc.spring.injection.UserServiceImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/06 22:31]
 */
@Configuration
@PropertySource("classpath:/init.properties")
public class AppConfig {

    @Value("${name}")
    private String name;
    @Value("${id}")
    private Integer id;

    @Bean(name = "userBean")
   /* @Scope("prototype")
    @Lazy*/
    public User user() {
        return new User();
    }

    @Bean
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql45",
                    "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    /*@Bean
    public UserService userService(UserDao userDao) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        return userService;
    }*/
    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao());
        return userService;
    }

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(id);
        return customer;
    }
}

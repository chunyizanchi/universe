package com.cyzc.spring.configuration;

import com.cyzc.spring.bean.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 11:36]
 */
@Configuration
@ComponentScan("com.cyzc.spring.bean")
@ImportResource("applicationContext-order.xml")
public class AppConfig3 {


    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setName("cyzc");
        customer.setAge(18);
        return customer;
    }
}

package com.cyzc.springboot.conf;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/15 23:56]
 */
@Configuration()
public class BeanConf {


    @Bean
    public String serviceName() {
        return "MyServiceName";
    }
}

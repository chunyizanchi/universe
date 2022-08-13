package com.cyzc.why;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.cyzc.why.mapper")
@ComponentScan("com.cyzc")
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class WhyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhyApplication.class, args);
    }

}

package com.cyzc.springboot;

import java.util.concurrent.ThreadPoolExecutor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("com.cyzc")
@MapperScan("com.cyzc.springboot.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class SpringbootApplication implements CommandLineRunner, ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner#run(String... args)");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner#run(ApplicationArguments args)");
    }
}

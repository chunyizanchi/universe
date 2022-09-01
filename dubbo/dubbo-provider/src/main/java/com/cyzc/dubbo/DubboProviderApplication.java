package com.cyzc.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboProviderApplication {

    private static final Logger logger = LoggerFactory.getLogger(DubboProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class,args);
        logger.info("ProviderApplication start!");
    }
}
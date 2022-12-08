package com.cyzc.rocketmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cyzc")
public class RocketMQProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQProducerApplication.class, args);
    }
}
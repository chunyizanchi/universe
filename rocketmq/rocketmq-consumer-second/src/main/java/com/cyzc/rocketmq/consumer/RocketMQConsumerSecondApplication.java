package com.cyzc.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cyzc")
public class RocketMQConsumerSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerSecondApplication.class, args);
    }
}
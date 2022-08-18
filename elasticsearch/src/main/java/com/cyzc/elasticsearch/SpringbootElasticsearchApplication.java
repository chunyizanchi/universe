package com.cyzc.elasticsearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cyzc")
public class SpringbootElasticsearchApplication {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
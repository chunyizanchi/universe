package com.cyzc.spring.annotationdev.life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/02 17:48]
 */
@Component
public class Product {

    @PostConstruct
    public void myInit() {
        System.out.println("Product init");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("Product destroy");
    }

}

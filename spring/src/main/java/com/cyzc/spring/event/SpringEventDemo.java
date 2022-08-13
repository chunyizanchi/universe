package com.cyzc.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/10 15:21]
 */
public class SpringEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //将监听器注入到容器中
        annotationConfigApplicationContext.register(Call119FireEventListener.class);
        annotationConfigApplicationContext.register(SavePersonFireEventListener.class);
        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.publishEvent(new FireEvent("着火了"));
    }
}

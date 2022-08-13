package com.cyzc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/10 10:43]
 */
public class TestLazyBean {

    @Test
    public void test() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.cyzc.spring.annotationdev.lazy");
        boolean account = ctx.containsBeanDefinition("account");
        System.out.println(account);

        //System.out.println(account);

    }
}

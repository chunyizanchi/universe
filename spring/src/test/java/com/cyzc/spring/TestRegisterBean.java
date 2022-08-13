package com.cyzc.spring;

import com.cyzc.spring.bean.PersonBean;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/10 14:10]
 */
public class TestRegisterBean {

    @Test
    public void testRegisterBean() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(PersonBean.class);
        annotationConfigApplicationContext.refresh();


        annotationConfigApplicationContext.close();

    }
}

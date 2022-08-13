package com.cyzc.spring.beanpost;

import com.cyzc.spring.life.Product;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/30 22:29]
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setId("970106");
            category.setName("gx");
        }else if (bean instanceof Product)
        System.out.println("bean"+bean+":beanName:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setId("970106");
            category.setName("gx");
        }
        return bean;
    }
}

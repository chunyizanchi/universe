package com.cyzc.spring.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 14:22]
 */
public class ProxyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    /**
     * Proxy.newProxyInstance()
     *
     * @param bean
     * @param beanName
     * @return {@link Object}
     * @author cyzc
     * @since 2022/4/1 14:23
     */

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(" ==== ProxyBeanPostProcessor postProcessAfterInitialization  ======");
                Object invoke = method.invoke(bean, args);
                return invoke;
            }
        };

        Object proxyInstance = Proxy.newProxyInstance(ProxyBeanPostProcessor.class.getClassLoader(),
                bean.getClass().getInterfaces(), handler);

        return proxyInstance;
    }
}

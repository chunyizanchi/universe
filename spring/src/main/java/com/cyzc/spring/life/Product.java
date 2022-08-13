package com.cyzc.spring.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p> 创建阶段
 *
 * @author Cyzc
 * @since [2022/03/30 18:05]
 */
public class Product implements InitializingBean, DisposableBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product afterPropertiesSet");
    }

    public Product() {
        System.out.println("Product produce");
    }

    public void initProduct() {
        System.out.println("Product initProduct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product destroy");
    }
    public void destroyProduct() {
        System.out.println("Product destroyProduct");
    }


}

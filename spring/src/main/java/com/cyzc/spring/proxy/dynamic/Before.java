package com.cyzc.spring.proxy.dynamic;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 11:24]
 */
public class Before implements MethodBeforeAdvice {
    /**
     * 原始方法运行之前
     * @author cyzc
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("==== method before advice ====");

    }
}

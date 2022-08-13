package com.cyzc.spring.proxy.dynamic;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 14:43]
 */
public class Before1 implements MethodBeforeAdvice {
    /**
     *
     * @author cyzc
     * @param method 增强的原始方法
     * @param args method 的参数
     * @param target 方法对应的原始对象
     * @return {@link Void}
     * @since 2022/3/31 14:48
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("Before1 before");
    }
}

package com.cyzc.spring.proxy.dynamic;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 15:03]
 */
public class Around implements MethodInterceptor {

    /**
     * @param invocation 额外功能所代表的原始方法 Method
     * @return {@link java.lang.Object} 原始方法执行完之后的返回值。
     * @since 2022/3/31 15:05
     */
    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        System.out.println("============  log ==========");
        Object proceed = invocation.proceed();
        //处理返回值 proceed
        return false;
    }
}

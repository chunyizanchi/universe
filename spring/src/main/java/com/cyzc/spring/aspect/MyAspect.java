package com.cyzc.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <p> 额外功能
 * public class myarround implements MethodInterceptor{ public Object invoke(MethodInvocation
 * invocation){ invocation.proceed(); } }
 *
 *
 * <p> 切入点
 * <aop:config>
 * <p>
 * <aop:pointcut id="pc" expression="@annotation(com.cyzc.spring.annotation.Log)"/>
 * <p>
 * <aop:advisor advice-ref="around" pointcut-ref="pc"/>
 * <p>
 * </aop:config>
 *
 * @author Cyzc
 * @since [2022/04/01 14:41]
 */
@Aspect
public class MyAspect {

    /**
     * ProceedingJoinPoint 等同于 MethodInvocation  ProceedingJoinPoint原始方法
     *
     * @param joinPoint
     * @return {@link Object}
     * @author cyzc
     * @since 2022/4/1 15:09
     */
    @Around("MyPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        //ProceedingJoinPoint 原始方法，
        Object proceed = null;
        try {
            System.out.println(" -- aspect log --");
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return proceed;

    }

    @Around("MyPointCut()")
    public Object around1(ProceedingJoinPoint joinPoint) {
        //ProceedingJoinPoint 原始方法，
        Object proceed = null;
        try {
            System.out.println(" -- aspect tx --");
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return proceed;

    }

    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void MyPointCut() {

    }
}

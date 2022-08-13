package com.cyzc.spring.aopdev;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 16:36]
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.cyzc.spring.aopdev..*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around");
        Object proceed = joinPoint.proceed();
        return proceed;
    }

}

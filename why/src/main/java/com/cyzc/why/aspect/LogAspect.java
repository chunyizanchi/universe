package com.cyzc.why.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2021/12/30 21:40]
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.cyzc.why.controller.TransactionController.*(..))")
    public void test() {

    }

    @Before("execution(public * com.cyzc.why.service.SellService.*(..))")
    public void doAccessCheck() {
        System.out.println("[Before] do access check...");
    }

    @Around("execution(public * com.cyzc.why.service.SellService.*(..))")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Around] start " + pjp.getSignature());
        Object retVal = pjp.proceed();
        System.out.println("[Around] done " + pjp.getSignature());
        return retVal;
    }

}

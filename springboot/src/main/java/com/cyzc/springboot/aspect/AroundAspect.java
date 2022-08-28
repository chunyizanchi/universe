package com.cyzc.springboot.aspect;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/26 22:45]
 */
@Aspect
@Component
@Slf4j
public class AroundAspect {

    @Pointcut("@annotation(com.cyzc.springboot.annotation.AroundAnnotation)")
    public void pointCutAnnotation() {
    }
    @Before("pointCutAnnotation()")
    public void doBefore() {
        log.info("Before");
    }

    @Around("pointCutAnnotation()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        System.out.println(args[0]);
        log.info("AroundAspect.around.arg=" + Arrays.toString(args));
        String name = joinPoint.getSignature().getName();
        log.info("AroundAspect.around.signature=" + name);

        return joinPoint.proceed();
    }



    @After("pointCutAnnotation()")
    public void doAfter() {
        log.info("After");
    }


    @AfterThrowing(pointcut = "pointCutAnnotation()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        log.info("AfterThrowing，Exception {}", e.getMessage());
    }

    @AfterReturning(pointcut = "pointCutAnnotation()", returning = "result")
    public void doAfterReturning(String result) {
        log.info("doAfterReturning result {}", result);
    }


}

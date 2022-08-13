package com.cyzc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/23 16:31]
 */
@Configuration
public class ThreadPoolAutoConfiguration {

    Logger logger=LoggerFactory.getLogger(ThreadPoolAutoConfiguration.class);

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class)
    public ThreadPoolExecutor diyThreadPoolExecutor() {
        logger.info("return autoConfiguration ThreadPoolExecutor");
        return new ThreadPoolExecutor(10, 50, 1000l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
    }
    @Bean
    @ConditionalOnBean(ThreadPoolExecutor.class)
    public ThreadPoolExecutor diyThreadPoolExecutor2() {
        logger.info("@ConditionalOnBean(ThreadPoolExecutor.class) return autoConfiguration ThreadPoolExecutor");
        return new ThreadPoolExecutor(10, 50, 1000l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
    }

    @Bean
    @ConditionalOnMissingClass("DemoDataListener")
    public String conditionalOnMissingClassTest() {
        logger.info("@ConditionalOnMissingClass(DemoDataListener)");
        return "success";

    }
}

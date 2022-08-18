package com.cyzc.springboot.conf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/18 16:36]
 */
@Configuration
public class ThreadPoolConf {


    @Bean("threadPoolExecutor1")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(10, 100, 100,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

    }
}

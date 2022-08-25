package com.cyzc.springboot.conf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setKeepAliveSeconds(10);
        threadPoolTaskExecutor.setQueueCapacity(30);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new AbortPolicy());
        //告诉线程池，在销毁之前执行 shutDown方法
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 调用 shutDown / shutDownnow 之后停止3s
        threadPoolTaskExecutor.setAwaitTerminationSeconds(3);
        return threadPoolTaskExecutor;
    }
}

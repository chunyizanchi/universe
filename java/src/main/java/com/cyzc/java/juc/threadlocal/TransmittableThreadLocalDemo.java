package com.cyzc.java.juc.threadlocal;

import cn.hutool.cron.task.RunnableTask;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/22 23:30]
 */
public class TransmittableThreadLocalDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    static ThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // 在父线程中设置
        context.set("first");
        //创建runnable 对象
        Runnable firstRunnable = () -> {
            String firstValue = context.get();
            System.out.println(firstValue);
        };
        //封装为TtlRunnable对象
        TtlRunnable firstTtlRunnable = TtlRunnable.get(firstRunnable);
        //提交任务
        executorService.execute(firstTtlRunnable);
        //确保线程池任务执行完
        Thread.sleep(10);

        context.set("second");
        //创建runnable 对象
        Runnable secondRunnable = () -> {
            String secondValue = context.get();
            System.out.println(secondValue);
        };
        //封装为TtlRunnable对象
        TtlRunnable secondTtlRunnable = TtlRunnable.get(secondRunnable);
        //提交任务
        executorService.execute(secondTtlRunnable);

        Thread.sleep(10);
        context.remove();

    }

}

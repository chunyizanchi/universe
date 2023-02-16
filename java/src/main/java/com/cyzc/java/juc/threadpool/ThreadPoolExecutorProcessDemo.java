package com.cyzc.java.juc.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <ThreadPoolExecutorProcessDemo>
 *
 * @author Cyzc
 * @since 2021-10-14
 */
public class ThreadPoolExecutorProcessDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                2,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3)
        );

        executor.execute(() -> {

            try {
                System.out.println(Thread.currentThread().getName()+"线程开始休眠");
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":done"+Thread.currentThread().isDaemon());

        });

        executor.execute(() -> System.out.println(Thread.currentThread().getName() + "第一个任务开始执行"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + "第二个任务开始执行"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + "第三个任务开始执行"));


    }

    private static void print(Integer integer) {
        System.out.println("executor" + integer);
    }

}
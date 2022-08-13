package com.cyzc.java.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-10-20
 */
public class ExecutorThreadErrorDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 2,
                30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        Future future = executorService.submit(() -> {
                sayHi("submit");
        });
        try {
            future.get();
        } catch (Exception e) {
            System.out.println("future.get Exception");
            e.printStackTrace();
        }
        System.out.println(future.get());

    }

    private static void sayHi(String name) throws RuntimeException {
        String printStr =
                "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",我异常啦!哈哈哈!");
    }
}
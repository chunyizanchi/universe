package com.cyzc.java.juc.threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/12 11:05]
 */
public class CompletableFutureDemo3 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureDemo3 completableFutureDemo = new CompletableFutureDemo3();

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        list.forEach(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-supplyAsync-" + s);
            String s1 = completableFutureDemo.funcA(s);
            System.out.println(Thread.currentThread().getName() + "-result-" + s);
            return s;
        }, executorService).whenComplete((returnStr, exception) -> {
            if (exception == null) {
                System.out.println(
                        Thread.currentThread().getName() + "-whenComplete-" + returnStr);
                if ("1".equals(returnStr)) {
                    try {
                        System.out.println(
                                Thread.currentThread().getName() + "-whenComplete sleep-"
                                        + returnStr);
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-complete-" + returnStr);
            } else {
                exception.printStackTrace();
            }
        }));

        executorService.shutdown();

    }

    String funcA(String s) {
        if ("1".equals(s)) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return s;
    }
}

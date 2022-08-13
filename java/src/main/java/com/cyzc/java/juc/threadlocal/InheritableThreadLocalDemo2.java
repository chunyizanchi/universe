package com.cyzc.java.juc.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/04 16:38]
 */
public class InheritableThreadLocalDemo2 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
        itl.set("first");
        executorService.execute(() -> {
            String firstValue = itl.get();
            System.out.println(firstValue);
        });
        //确保线程池任务执行完
        Thread.sleep(10);
        itl.remove();

        itl.set("second");
        executorService.execute(() -> {
            String secondValue = itl.get();
            System.out.println(secondValue);
        });
        //确保线程池任务执行完
        Thread.sleep(10);
        itl.remove();
    }
}

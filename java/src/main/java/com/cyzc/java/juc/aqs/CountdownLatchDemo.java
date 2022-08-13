package com.cyzc.java.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p> CountdownLatch
 *
 * @author Cyzc
 * @since [2021/12/29 16:43]
 */
public class CountdownLatchDemo {
    static int totalThreads = 10;

    static CountDownLatch countDownLatch = new CountDownLatch(totalThreads);

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThreads; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println("run .." + finalI);
                //把数值倒数 1，也就是将 count 值减 1，直到减为 0 时，之前等待的线程会被唤起。
                countDownLatch.countDown();
            });
        }
        //执行等待，只有倒数结束时才户籍需执行
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();


    }

}

package com.cyzc.java.juc.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>CyclicBarrier
 *
 * @author Cyzc
 * @since [2021/12/31 10:10]
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        int totalThread = 10;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThread; i++) {

            executorService.execute(() -> {
                String currentThreadName = Thread.currentThread().getName();
                System.out.println("before ..." + currentThreadName);
                //先调用完 cyclicBarrier.await(); 前的所有方法
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //先调用完 cyclicBarrier.await(); 前的所有方法 调用完之后再执行之后的方法
                System.out.println("after" + currentThreadName);
            });

        }
        executorService.shutdown();
    }
}

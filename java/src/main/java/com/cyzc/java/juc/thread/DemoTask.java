package com.cyzc.java.juc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/10 11:13]
 */
public class DemoTask implements Runnable {

    // 主线程要等待线程打印完毕，使用CountDownLatch通知机制
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static List<ExecutorService> threadList = new ArrayList<>();
    private static final int MAX = 3;
    private static int current = 1;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (current <= MAX) {
            System.out.println("threadName"+name+"打印了"+current++);
            threadList.get(current % threadList.size()).submit(new DemoTask());
        } else {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            threadList.add(Executors.newFixedThreadPool(1));
        }

        threadList.get(0).submit(new DemoTask());
        countDownLatch.await();
        threadList.forEach(ExecutorService::shutdown);
    }
}

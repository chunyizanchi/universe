package com.cyzc.java.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p> 这里主要是根据 countDownLatch 的 await()方法和 countDown()方法的配合。
 * 深入理解一下 countDownLatch 的流程
 * 1. 先构造一个计数器
 * 2. 执行业务代码, 调用countDown()方法使计数器减一
 * 3. 执行等到 countDown() 执行完毕，可以执行 await()方法。执行后续的方法。
 *
 * @author Cyzc
 * @since [2022/03/21 14:47]
 */
public class CountDownLatchDemo3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("运动员有五秒钟的准备时间");
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable runnable = () -> {
                System.out.println(no + "号运动员准备成功，等待开枪");
                try {
                    countDownLatch.await();
                    System.out.println(no + "号运动员开始跑步");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.submit(runnable);
        }
        Thread.sleep(5000);
        System.out.println("5 秒时间已过，发令枪响，比赛开始");
        // 执行  countDownLatch.countDown();使得 计数器开始减1,减完1,  countDownLatch.await();后面的代码就可以执行了
        countDownLatch.countDown();
    }

}

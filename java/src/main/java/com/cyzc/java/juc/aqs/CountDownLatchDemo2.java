package com.cyzc.java.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/21 14:40]
 */
public class CountDownLatchDemo2 {

    static CountDownLatch countDownLatch = new CountDownLatch(5);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable runnable = () -> {
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println(no + "号运动员完成了比赛。");

                } catch (InterruptedException e) {

                    e.printStackTrace();

                } finally {
                    countDownLatch.countDown();

                }

            };
            service.submit(runnable);

        }
        System.out.println("等待5个运动员都跑完.....");
        //需要等待  countDownLatch.countDown();主线程需要等待全部执行完
        countDownLatch.await();

        System.out.println("所有人都跑完了，比赛结束。");

    }

}

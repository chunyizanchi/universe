package com.cyzc.java.juc.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p> CyclicBarrier 这个工具类可以拆分任务，通过构造函数里的int 值，每达到int 值之后执行后续代码
 *
 * @author Cyzc
 * @since [2022/03/21 15:07]
 */
public class CyclicBarrierDemo2 {

    public static void main(String[] args) {
        // 3个线程到达集结点才统一放行
        //CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        // public CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("凑齐三个人了，出发");
            }
        });
        for (int i = 0; i < 6; i++) {
            new Thread(new Task(i + 1, cyclicBarrier)).start();
        }

    }

    static class Task implements Runnable {

        private  int id;
        private  CyclicBarrier cyclicBarrier;

        public Task(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("同学" + id + "现在从大门出发，赶往自行车驿站");

            try {
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("同学" + id + "到达了自行车驿站，开始等待其他人到达");
                cyclicBarrier.await();
                System.out.println("同学" + id + "开始骑车");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

}

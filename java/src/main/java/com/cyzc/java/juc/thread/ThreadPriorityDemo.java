package com.cyzc.java.juc.thread;

import java.util.stream.IntStream;

/**
 * Java提供一个线程调度器来监视和控制处于RUNNABLE状态的线程。线程的调度策略采用抢占式，
 * 优先级高的线程比优先级低的线程会有更大的几率优先执行。在优先级相同的情况下，按照“先到先得”的原则。
 * 每个Java程序都有一个默认的主线程，就是通过JVM启动的第一个线程main线程。
 *
 * @author Cyzc
 * @since [2021/12/20 16:29]
 */
public class ThreadPriorityDemo {

    public static class T1 extends Thread {

        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static void main(String[] args) {
       /* Thread a = new Thread();
        System.out.println("我是默认线程优先级："+a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级："+b.getPriority());*/
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }
}

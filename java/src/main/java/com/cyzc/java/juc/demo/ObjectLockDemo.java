package com.cyzc.java.juc.demo;

/**
 *  * 该类 线程A执行完才执行线程B 对比下面的类
 *  <p>{@link com.cyzc.java.juc.thread.WaitAndNotifyDemo}
 *
 * @author Cyzc
 * @since [2021/12/20 17:32]
 */
public class ObjectLockDemo {
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }
}

package com.cyzc.java.juc.thread;

/**
 * 使用线程间的通信方法 {@link Object#wait()} 和 {@link Object#notify()} ()}
 * 进行线程间的通信
 *
 * @author Cyzc
 * @since [2021/12/20 17:37]
 */
public class WaitAndNotifyDemo {

    private static Object lock = new Object();

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            System.out.println("ThreadA:开始执行");
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            System.out.println("ThreadB:开始执行");
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();//
                        lock.wait();//Thread B 让自己进入等待状态，释放 lock 的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }

}

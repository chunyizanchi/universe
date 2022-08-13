package com.cyzc.java.juc.thread;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/20 17:30]
 */
public class NonLockDemo {

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread A " + i);
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread B " + i);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}

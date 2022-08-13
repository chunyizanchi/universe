package com.cyzc.java.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p> 三个线程分别打印 A,B,C
 *
 * @author Cyzc
 * @since [2022/06/21 22:07]
 */
public class test3 {

    private static int state = 0;


    public static void main(String[] args) {
        final Lock l = new ReentrantLock();

        Thread A = new Thread(() -> {
            while (state <= 30) {
                l.lock();
                if (state % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + "打印了A");
                    state++;
                }
                l.unlock();
            }
        });
        Thread B = new Thread(() -> {
            while (state <= 30) {
                l.lock();
                if (state % 3 == 1) {
                    System.out.println(Thread.currentThread().getName() + "打印了B");
                    state++;
                }
                l.unlock();
            }
        });
        Thread C = new Thread(() -> {
            while (state <= 30) {
                l.lock();
                if (state % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + "打印了C");
                    state++;
                }
                l.unlock();
            }
        });
        A.setName("A");
        B.setName("B");
        C.setName("C");
        A.start();
        B.start();
        C.start();
    }
}

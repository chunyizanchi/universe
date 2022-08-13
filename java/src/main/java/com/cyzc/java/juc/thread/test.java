package com.cyzc.java.juc.thread;

/**
 * <p> 两个线程顺序打印。线程a打印奇数，线程b打印偶数
 *
 * @author Cyzc
 * @since [2022/03/28 17:15]
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            for (int j = 1; j <= 100; j++) {
                synchronized (o) {
                    if (j % 2 == 1) {
                        System.out.println(Thread.currentThread().getName()+"--"+j);
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        o.notifyAll();
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int j = 1; j <= 100; j++) {
                synchronized (o) {
                    if (j % 2 == 0) {
                        System.out.println(Thread.currentThread().getName()+"--"+j);
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        o.notifyAll();
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }

}

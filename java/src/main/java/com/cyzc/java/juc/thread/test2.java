package com.cyzc.java.juc.thread;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/28 17:31]
 */
public class test2 {
    static volatile boolean flag = false;
    static int i = 1;

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(() -> {
            while (i < 100) {
                synchronized (o) {
                    if (flag) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        flag=true;
                        System.out.println(Thread.currentThread().getName()+"--"+i);
                        i++;
                        o.notifyAll();
                    }
                }
            }
        }).start();
        //Thread.sleep(1000);
        new Thread(() -> {
            while (i < 100) {
                synchronized (o) {
                    if (flag) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        flag=true;
                        System.out.println(Thread.currentThread().getName()+"--"+i);
                        i++;
                        o.notifyAll();
                    }
                }
            }
        }).start();
    }

}

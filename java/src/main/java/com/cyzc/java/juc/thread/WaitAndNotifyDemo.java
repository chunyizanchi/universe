package com.cyzc.java.juc.thread;

/**
 * 使用线程间的通信方法 {@link Object#wait()} 和 {@link Object#notify()} ()}
 * 如何进行通信呢？ 首先有一个共享对象 Object。线程调用object的 wait方法会释放锁。这时 </br>
 * 进行线程间的通信 </br>
 * <br>我没搞懂啥呢？ 1. wait 和 notify 方法的作用，对于线程的影响，对锁对象的影响。</br>
 * @author Cyzc
 * @since [2021/12/20 17:37]
 */
public class WaitAndNotifyDemo {
    //对象，用于表示共享变量
    private static Object lock = new Object();

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            System.out.println("ThreadA:开始执行");
            synchronized (lock) {
                System.out.println("ThreadA 拿到 lock 锁");
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        //lock.notify 唤醒因lock.wait进入等待状态的线程
                        lock.notify();
                        //ThreadA 进入 wait状态，直到lock对象的notify方法被调用，释放锁
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
                System.out.println("ThreadB 拿到 lock 锁");
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
        //这里是确保A执行
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }

}

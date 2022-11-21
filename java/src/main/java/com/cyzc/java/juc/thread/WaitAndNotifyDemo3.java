package com.cyzc.java.juc.thread;

/**
 * <p> 线程A 打印偶数，线程b打印奇数
 *
 * @author Cyzc
 * @since [2022/11/19 22:58]
 */
public class WaitAndNotifyDemo3 {

    public static void main(String[] args) {
        WaitAndNotifyDemo3 waitAndNotifyDemo3=new WaitAndNotifyDemo3();

        new Thread(new ThreadA(waitAndNotifyDemo3)).start();
        new Thread(new ThreadB(waitAndNotifyDemo3)).start();
    }
}
class ThreadA implements Runnable{
    Object object;

    public ThreadA(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i = 0; i < 100; i++) {
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    object.notifyAll();

                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }

    }
}

class ThreadB implements Runnable{
    Object object;

    public ThreadB(Object object) {
        this.object = object;
    }
    @Override
    public void run() {
        synchronized (object){
            for (int i = 0; i < 100; i++) {
                if (i%2==1){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    object.notifyAll();

                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }
}

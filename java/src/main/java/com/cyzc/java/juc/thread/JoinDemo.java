package com.cyzc.java.juc.thread;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/21 21:29]
 */
public class JoinDemo {

    static class ThreadA implements Runnable {

        @Override
        public void run() {

            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new ThreadA());
        //在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
        //这里就是main线程调用了 thread的join方法，将main线程挂起，等到执行完thread方法后。
        //所以说在进行单侧的时候，最后调用一下 join，避免mian线程走完 直接退出
        thread.start();
        //join 的核心是调用线程调用 wait 方法。debug试一下就知道啦
        thread.join();

        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");
    }


}

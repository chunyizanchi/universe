package com.cyzc.java.bug;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/15 10:46]
 */
public class SynchronizedBug {

    public static void main(String[] args) {

        Thread why = new Thread(new TicketConsumer(10), "why");
        Thread mx = new Thread(new TicketConsumer(10), "mx");
        why.start();
        mx.start();
    }

    /*class TicketConsumer implements Runnable {
        //Static declarations in inner classes are not supported at language level '8'
        private volatile static Integer ticket;

        public TicketConsumer(int ticket) {
            this.ticket = ticket;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "开始抢第" + ticket + "张票，对象加锁之前：" + System.identityHashCode(ticket));
                synchronized (ticket) {
                    System.out.println(Thread.currentThread().getName() + "抢到第" + ticket + "张票，成功锁到的对象：" + System.identityHashCode(ticket));
                    if (ticket > 0) {
                        try {
                            //模拟抢票延迟
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票，票数减一");
                    } else {
                        return;
                    }
                }
            }
        }*/

}

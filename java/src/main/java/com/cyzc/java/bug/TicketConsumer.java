package com.cyzc.java.bug;

import java.util.concurrent.TimeUnit;

/**
 * <p>synchronized  失效是因为 why神文章 锁一个 包装类型会失效， <a href="https://www.whywhy.vip/archives/158">当Synchronized遇到这玩意儿，有个大坑，要注意！</a>
 *
 * @author Cyzc
 * @since [2022/06/15 10:48]
 */
public class TicketConsumer implements Runnable {

    private volatile static Integer ticket;

    public TicketConsumer(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始抢第" + ticket + "张票，对象加锁之前："
                    + System.identityHashCode(ticket));
            synchronized (ticket) {
                System.out.println(Thread.currentThread().getName() + "抢到第" + ticket + "张票，成功锁到的对象："
                        + System.identityHashCode(ticket));
                if (ticket > 0) {
                    try {
                        //模拟抢票延迟
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(
                            Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票，票数减一");
                } else {
                    return;
                }
            }
        }
    }
}

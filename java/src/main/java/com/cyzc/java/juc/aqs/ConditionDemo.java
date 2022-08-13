package com.cyzc.java.juc.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/21 16:43]
 */
public class ConditionDemo {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    void method1() throws InterruptedException {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + ":条件不满足，开始await");
            condition.await();
            System.out.println(Thread.currentThread().getName() + ":条件满足了，开始执行后续的任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void method2() throws InterruptedException {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + ":需要5 s 准备时间");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":准备工作完成，唤醒其他的线程");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionDemo.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        conditionDemo.method1();

    }
}

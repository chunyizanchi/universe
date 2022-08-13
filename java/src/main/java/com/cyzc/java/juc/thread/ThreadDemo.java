package com.cyzc.java.juc.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程不能重复调用 {@link Thread#start()} 方法 threadStatus会被修改
 *
 *
 * @author Cyzc
 * @since [2021/12/08 17:19]
 */
@Slf4j
public class ThreadDemo {

    public static class MyThread implements Runnable {
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
        }
    }



    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread test = new Thread(new MyThread(), "test"+i);
            test.start();
          //  System.out.println(Thread.currentThread().getName());
        }

       /* Thread test = new Thread(new MyThread(), "test");
        test.start();
        Thread.yield();
        String name = Thread.currentThread().getName();
       log.info("threadName"+name);

        new Thread(()-> System.out.println(Thread.currentThread().getName()+"匿名内部类"),"testLambda").start();*/


    }

}

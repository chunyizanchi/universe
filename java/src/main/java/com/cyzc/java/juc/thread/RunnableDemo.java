package com.cyzc.java.juc.thread;

import java.util.concurrent.Callable;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/15 17:02]
 */
public class RunnableDemo {

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"==runnable");
            }
        };
        runnable.run();

        Thread t=new Thread(runnable);
        t.start();

    }
}

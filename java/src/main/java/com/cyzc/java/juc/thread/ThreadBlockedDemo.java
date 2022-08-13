package com.cyzc.java.juc.thread;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/09 07:47]
 */
public class ThreadBlockedDemo {

    public static void main(String[] args) {
        //Thread a = new Thread(testMethod());
    }

    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

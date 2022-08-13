package com.cyzc.java.juc.threadlocal;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/03 10:56]
 */
public class ThreadLocalsDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> tlString = new ThreadLocal<>();
        ThreadLocal<Integer> tlInteger = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            tlString.set("foo");
            tlInteger.set(1);
            System.out.println("t1 tlString  ="+tlString.get());
            System.out.println("t1 tlInteger ="+tlInteger.get());
        });

        Thread t2 = new Thread(() -> {
            tlString.set("bar");
            tlInteger.set(2);
            System.out.println("t2 tlString  ="+tlString.get());
            System.out.println("t2 tlInteger ="+tlInteger.get());
        });


        t1.start();
        t1.join();
        t2.start();


    }
}

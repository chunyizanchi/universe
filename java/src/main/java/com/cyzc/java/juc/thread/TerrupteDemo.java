package com.cyzc.java.juc.thread;

import java.util.Collections;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/13 23:04]
 */
public class TerrupteDemo {

    public static void main(String[] args) {

        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());


    }

}

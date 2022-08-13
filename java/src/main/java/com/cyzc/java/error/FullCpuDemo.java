package com.cyzc.java.error;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/23 14:13]
 */
public class FullCpuDemo {

    public static void main(String[] args) {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }
}

package com.cyzc.java.juc.demo;

/**

 *
 * @author Cyzc
 * @since [2021/12/25 16:13]
 */
public class VolatileDemo {
    int a=0;
    volatile boolean flag=false;

    public void write(){
        a = 1; // step 1
        flag = true; // step 2
    }

    public void read(){
        if (flag) { // step 3
            System.out.println(a); // step 4
        }
    }
}

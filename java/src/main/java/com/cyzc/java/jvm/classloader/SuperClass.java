package com.cyzc.java.jvm.classloader;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-09
 */
public class SuperClass {

    static {
        int i=0;
        System.out.println(i);
        System.out.println("SuperClass init");
    }
    public static int value=1;
}
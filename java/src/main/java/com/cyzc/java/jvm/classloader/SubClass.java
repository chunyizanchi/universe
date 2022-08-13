package com.cyzc.java.jvm.classloader;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-09
 */
public class SubClass extends SuperClass{

    static {
        System.out.println("SubClass init");
    }
    public static int value=2;
}
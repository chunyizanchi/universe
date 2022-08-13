package com.cyzc.java.jvm.classloader;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/28 07:58]
 */
public class StaticValue {
    static {
        A=3;
    }
    public static int A=1;


    public static void main(String[] args) {
        System.out.println(A);
    }
}

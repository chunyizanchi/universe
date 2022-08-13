package com.cyzc.java.jvm;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-02
 */
public class InvokeVirtualTest {

    public static void main(String[] args) {
        Father test=new Son();
        test.say();
    }

}

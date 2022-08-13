package com.cyzc.java.version.java8;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/14 23:58]
 */
public class InterfaceDefaultImpl implements InterfaceDefault{

    @Override
    public void test1() {

    }

    @Override
    public void test2() {
        InterfaceDefault.super.test2();
    }
}

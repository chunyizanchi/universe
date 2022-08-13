package com.cyzc.java.version.java8;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/14 23:56]
 */
public interface InterfaceDefault {
    void test1();

    default void test2(){
        System.out.println("test2");
    }

}

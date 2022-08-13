package com.cyzc.java.basic;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/14 11:05]
 */
public class Son extends Father{

    public Son() {
        System.out.println("子类无参构造");
    }

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类普通代码块");
    }

}

package com.cyzc.java.basic;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/14 11:05]
 */
public class Father {

    public Father() {
        System.out.println("父类无参构造");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类普通代码块");
    }
}

package com.cyzc.java.jvm;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-02
 */
public class Father {
    public void say(){
        System.out.println("i am father");
        System.out.println(this);
        this.hello();
        this.hi();
    }

    private void hello(){
        System.out.println("father say hello");
    }
    public void hi(){
        System.out.println("father say hi");
    }
}

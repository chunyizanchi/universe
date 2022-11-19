package com.cyzc.java.superD;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/17 15:52]
 */
public class SuperSonDemo extends SuperDemo{

    private int z;

    public SuperSonDemo(int x, int y,int z) {
        super(x, y);
        this.z=z;
    }

    @Override
    public void func() {
        super.func();
        System.out.println("SuperSonDemo#func");
    }
}

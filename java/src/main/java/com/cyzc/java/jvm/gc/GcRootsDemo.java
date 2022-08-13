package com.cyzc.java.jvm.gc;

import com.cyzc.java.entity.GcRoots;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/30 16:33]
 */
public class GcRootsDemo {

    //类静态属性
    public static GcRoots staticAttribute;
    //常量
    public final GcRoots finalAttribute = new GcRoots();
    static final GcRoots synchronizedAttribute = new GcRoots();

    public static void main(String[] args) {
        //虚拟机栈所引用的对象
        GcRoots gcRoots = new GcRoots();

        GcRootsDemo gcRootsDemo = new GcRootsDemo();
        //方法区中类静态属性引用的对象 引用的是GC roots
        GcRoots staticAttribute1 = GcRootsDemo.staticAttribute;
        //常量引用的对象 引用的是gcroots
        GcRoots finalAttribute1 = gcRootsDemo.finalAttribute;

        //synchronized 持有的对象
        synchronized (synchronizedAttribute) {
            System.out.println("GcRoots.class 被同步锁锁住了，所以可以作为GC roots");
        }
    }
}

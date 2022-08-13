package com.cyzc.java.jvm.gc;

/**
 * <循环引用状态下 依旧GC>
 *  从侧面说明了Java虚拟机并不是通过引用计数算法来判断对象
 *  是否存活的
 * @author Cyzc
 * @since 2021-08-20
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;
    /**
     * 占一点内存
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();

        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA=null;

        objB=null;

        System.gc();

    }

    public static void main(String[] args) {
        testGC();
    }


}
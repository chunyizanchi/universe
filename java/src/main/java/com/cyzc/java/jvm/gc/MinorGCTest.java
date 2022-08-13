package com.cyzc.java.jvm.gc;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-11-12
 */
public class MinorGCTest {

    private static final int _1MB = 1024 * 1024;
    private static final int _MB = 512 * 1024;

    /*
     * vm 参数:  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testAllocation() {

        byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6,allocation7;
        allocation1 = new byte[2 * _1MB];
        //allocation2 = new byte[2 * _1MB];
        //allocation3 = new byte[2 * _1MB];
        //allocation4 = new byte[4 * _1MB];
       //allocation5 = new byte[9 * _1MB];
       allocation6 = new byte[_MB];
       allocation7 = new byte[_1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
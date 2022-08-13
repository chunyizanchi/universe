package com.cyzc.java.operator;

import org.apache.dubbo.rpc.RpcContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/11 10:55]
 */
public class BitOperationTest {

    public static void main(String[] args) {
        int a=60;
        int b=13;
        boolean c=true;
        boolean d=false;
        boolean e=true;
        System.out.println(a&b);
        System.out.println(c&d);
        System.out.println(c&&d);
        System.out.println(c&e);

        System.out.println(c|d);
        System.out.println(c||d);
        System.out.println(c|e);

    }

}

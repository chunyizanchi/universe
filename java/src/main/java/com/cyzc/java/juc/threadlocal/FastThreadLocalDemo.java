package com.cyzc.java.juc.threadlocal;

import io.netty.util.concurrent.FastThreadLocal;
import org.apache.dubbo.common.threadlocal.InternalThread;
import org.apache.dubbo.common.threadlocal.InternalThreadLocal;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 12:35]
 */
public class FastThreadLocalDemo {

    private static FastThreadLocal<Integer> fastThreadLocal = new FastThreadLocal<>();

    public static void main(String[] args) {

    }
}

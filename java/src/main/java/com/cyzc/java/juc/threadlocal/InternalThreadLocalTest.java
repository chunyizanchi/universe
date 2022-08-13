package com.cyzc.java.juc.threadlocal;

import org.apache.dubbo.common.threadlocal.InternalThread;
import org.apache.dubbo.common.threadlocal.InternalThreadLocal;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/23 18:44]
 */
public class InternalThreadLocalTest {
    private static InternalThreadLocal<Integer> internalThreadLocal_0 = new InternalThreadLocal<>();

    public static void main(String[] args) {
        new InternalThread(() -> {
            for (int i = 0; i < 5; i++) {
                internalThreadLocal_0.set(i);
                Integer value = internalThreadLocal_0.get();
                System.out.println(Thread.currentThread().getName()+":"+value);
            }
        }, "internalThread_have_set").start();

        new InternalThread(() -> {
            for (int i = 0; i < 5; i++) {
                Integer value = internalThreadLocal_0.get();
                System.out.println(Thread.currentThread().getName()+":"+value);
            }
        }, "internalThread_no_set").start();
    }
}

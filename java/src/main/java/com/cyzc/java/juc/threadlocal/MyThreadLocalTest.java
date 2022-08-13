package com.cyzc.java.juc.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 13:01]
 */
public class MyThreadLocalTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ThreadLocal<Object> tl1 = new MyThreadLocal<>();
        ThreadLocal<Object> tl2 = new MyThreadLocal<>();


// ------------第一次调用 start -------------------
        tl1.set("1111");
        tl2.set("2222");

        executorService.execute(new MyTask(() -> {
            // do biz
            System.out.println(tl1.get());
            System.out.println(tl2.get());
        }));

        tl1.remove();
        tl2.remove();
// ------------第一次调用 end -------------------


// ------------第二次调用 start -------------------
        tl1.set("3333");
        tl2.set("4444");

        executorService.execute(new MyTask(() -> {
            // do biz
            System.out.println(tl1.get());
            System.out.println(tl2.get());
        }));

        tl1.remove();
        tl2.remove();
// ------------第二次调用 end -------------------

    }

}

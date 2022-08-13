package com.cyzc.java.juc.threadlocal;

import com.cyzc.java.entity.RedSpider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/03 16:22]
 */
public class ThreadLocalOOMDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            ThreadLocal<RedSpider> threadLocal = new ThreadLocal<>();
            RedSpider redSpider = new RedSpider();
            threadLocal.set(redSpider);
        });
    }
}

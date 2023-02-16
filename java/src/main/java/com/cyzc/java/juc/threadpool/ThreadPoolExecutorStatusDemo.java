package com.cyzc.java.juc.threadpool;

import cn.hutool.core.thread.NamedThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-10-13
 */

public class ThreadPoolExecutorStatusDemo {

    public static void main(String[] args) {

        final ThreadPoolExecutor executor = buildThreadPoolExecutor();


    }


    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new ResizeCapacityLinkedBlockingQueue<>(10),
                new NamedThreadFactory("testThreadPoolStatus", false));
    }
}
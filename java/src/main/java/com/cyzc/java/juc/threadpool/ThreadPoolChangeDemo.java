package com.cyzc.java.juc.threadpool;

import cn.hutool.core.thread.NamedThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * <描述>
 * {@link ThreadPoolExecutor}
 * @author Cyzc
 * @since 2021-10-09
 */
@Slf4j
public class ThreadPoolChangeDemo {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        dynamicModifyExecutor();
    }


    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new ResizeCapacityLinkedBlockingQueue<>(10),
                new NamedThreadFactory("cyzc", false));
    }


    /**
     * 提交任务给线程池，并修改线程池参数
     *
     * @return {@link Void}
     * @author cyzc
     * @since 2021/10/9 11:57
     */
    private static void dynamicModifyExecutor() throws InterruptedException, ClassNotFoundException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();

        for (int i = 0; i < 15; i++) {

            executor.submit(() -> {
                threadPoolStatus(executor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor, "改变之前");
        TimeUnit.SECONDS.sleep(1);
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        ResizeCapacityLinkedBlockingQueue queue= (ResizeCapacityLinkedBlockingQueue) executor.getQueue();
        queue.setCapacity(100);
        executor.prestartCoreThread();
        threadPoolStatus(executor, "改变之后");
        Thread.currentThread().join();


    }

    /**
     * 打印线程池状态
     *
     * @param executor
     * @param name
     * @return {@link Void}
     * @author cyzc
     * @since 2021/10/9 11:57
     */
    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        ResizeCapacityLinkedBlockingQueue queue = (ResizeCapacityLinkedBlockingQueue) executor.getQueue();

        System.out.println(Thread.currentThread().getName() + "-" + name + "-: " +
                " 核心线程数：" + executor.getCorePoolSize() +
                " 活动线程数：" + executor.getActiveCount() +
                " 最大线程数：" + executor.getMaximumPoolSize() +
                " 线程池活跃度：" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                " 任务完成数：" + executor.getCompletedTaskCount() +
                " 队列大小：" + (queue.size() + queue.remainingCapacity()) +
                " 当前排队线程数：" + queue.size() +
                " 队列剩余大小:" + queue.remainingCapacity() +
                " 队列使用度：" + divide(queue.size(), queue.size() + queue.remainingCapacity())
        );

    }

    /**
     * 保留两位小数
     *
     * @param num1
     * @param num2
     * @return {@link String}
     * @author cyzc
     * @since 2021/10/9 11:56
     */
    private static String divide(int num1, int num2) {
        return String.format("%1.2f%%",
                Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100);

    }


}
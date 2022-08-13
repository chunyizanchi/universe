package com.cyzc.java.juc.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>CompletableFutureDemo</p>
 * <p>CompletableFuture 默认使用 ForkJoinPool {@link CompletableFuture#asyncPool }</p>
 * 而 ForkJoinPool 中设置的线程为 守护线程 {@link java.util.concurrent.ForkJoinPool#registerWorker(ForkJoinWorkerThread)}
 * 中  wt.setDaemon(true); 守护线程是什么，守护线程退出之后 jvm退出，程序就结束运行，导致守护线程执行完任务关闭之后，还有剩余的任务没执行完。
 * <p>处理方法：1：主线程阻塞 或者 sleep 一下 2：自定义线程池</p>
 * <p>对于ForkJoinPool 线程池</p>
 *
 * @author Cyzc
 * @since 2021-10-11
 */
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神： 开始化妆了,好了我叫你");

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "化妆完毕了。";
        }, executorService).whenComplete((returnStr, exception) -> {
            if (exception == null) {
                System.out.println(Thread.currentThread().getName() + "-" + returnStr);
                System.out.println(Thread.currentThread().getName() + "-" + "出去玩吧，靓仔");
            } else {
                System.out.println(Thread.currentThread().getName() + "女神放你鸽子了");
                exception.printStackTrace();
            }
        }).exceptionally((e) -> {
            //处理异常情况
            e.printStackTrace();
            return null;
        });
        System.out.println(Thread.currentThread().getName() + " 自己做一些自己的事情");
        System.out.println(Thread.currentThread().getName() + " 去点个奶茶");
        //Thread.currentThread().join();
      /*  if (ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS)) {
            System.out.println("异步线程全部执行完毕了！");
        } else {
            System.out.println("异步线程没有执行完，但是JVM 退出了");
        }*/
    }

}
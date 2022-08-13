package com.cyzc.why.demo;

import io.lettuce.core.ScriptOutputType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/11 09:05]
 */
public class why20220711 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    System.out.println("call able:" + finalI);
                    Thread.sleep(500);
                    return null;
                }
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Executor executor = getExecutor();
        new Thread(() -> {
            try {
                executorService.invokeAll(tasks);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("invoke all returned");
        }).start();

        Thread.sleep(800);
        System.out.println("shutdown");
        // executorService.shutdown();
        List<Runnable> runnables = executorService.shutdownNow();
        for (Runnable r : runnables
        ) {
            if (r instanceof Future) {
                ((Future<?>) r).cancel(false);
                System.out.println("cancel success");
            }

        }

        System.out.println("shutdown complete");

    }


    public static Executor getExecutor() {
        System.out.println("自建线程池");
        return new ThreadPoolExecutor(
                1,
                1, 100l,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new DiscardPolicy()
        );
    }


}

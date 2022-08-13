package com.cyzc.java.juc.threadpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/12 10:24]
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> ls1 = Collections.singletonList(1);

        List<Integer> is = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (Integer i : ls) {
            CompletableFuture.supplyAsync(() -> {
        /*if (i == 1) {
            try {
                System.out.println("1 RUN SLEEP");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
                System.out.println(i + "/" + Thread.currentThread().getName() + "/DO SOMETHINGS");
                return i;
            }, executorService).whenComplete((rtn, ex) -> {
                if (ex == null) {
                    System.out.println(i + "/" + Thread.currentThread().getName() + "/START");
                    if (i == 1) {
                        try {
                            System.out.println(
                                    i + "/" + Thread.currentThread().getName() + "/COMPLETE SLEEP");
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    is.add(i);
                    System.out.println(i + "/" + Thread.currentThread().getName() + "/COMPLETE");
                } else {
                    ex.printStackTrace();
                }
            });
        }
        Thread.sleep(20000);
        System.out.println(is);
        executorService.shutdown();
    }

}

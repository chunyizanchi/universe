package com.cyzc.java.juc.threadpool;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/08 15:00]
 */
public class FutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        List<Future> l= Lists.newArrayList();

      /*  ArrayList<String> objects = Lists.newArrayList();
        for (String s : list) {
            Future f = executorService.submit(() -> completableFutureDemo.(s));
            l.add(f);
        }

        for (Future f:l){
            String o = (String)f.get();
            objects.add(o);
            //System.out.println("thread name"+Thread.currentThread().getName()+"====result:"+o);
        }*/
    }
}

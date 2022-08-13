package com.cyzc.java.juc.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import javafx.concurrent.Task;

/**
 *
 *
 *
 * @author Cyzc
 * @since [2021/12/08 17:47]
 */
public class FutureDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(100);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureDemo futureDemo=new FutureDemo();
        Future<Integer> futureTask =  executorService.submit(futureDemo);

        //Waits if necessary for the computation to complete, and then retrieves its result.
        System.out.println(futureTask.get());

    }
}

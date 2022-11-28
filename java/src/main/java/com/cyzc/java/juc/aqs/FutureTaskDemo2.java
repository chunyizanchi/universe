package com.cyzc.java.juc.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/21 16:19]
 */
public class FutureTaskDemo2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new FutureTaskDemo2());
/*
        FutureTask<String> futureTask=new FutureTask<String>(new FutureTaskDemo2());
        executorService.submit(futureTask);

        try {
            futureTask.get();
            System.out.println(futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }*/


        //cancel 取消任务的之心，如果任务已经完成，或者已经被取消，则返回false。如果任务没执行，返回true并且
        System.out.println(submit.cancel(true));//什么情况下会返回 ture?

        executorService.shutdown();
    }
}

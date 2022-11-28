package com.cyzc.java.juc.aqs;

import com.cyzc.java.juc.demo.FutureDemo;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 前面说到了Future只是一个接口，而它里面的cancel，get，isDone等方法要自己实现起来都是非常复杂的。所以JDK提供了一个FutureTask类来供我们使用。
 *  FutureTask能够在高并发环境下确保任务只执行一次
 * @author Cyzc
 * @since [2021/12/20 16:17]
 */
public class FutureTaskDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(100);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<Integer> futureTask = new FutureTask<>(new FutureDemo());
        executorService.submit(futureTask);
        //Waits if necessary for the computation to complete, and then retrieves its result.
        System.out.println(futureTask.get());

    }
}

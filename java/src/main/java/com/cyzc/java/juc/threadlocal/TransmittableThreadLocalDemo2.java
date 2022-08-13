package com.cyzc.java.juc.threadlocal;


import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/06 07:46]
 */
public class TransmittableThreadLocalDemo2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 额外的处理，生成修饰了的对象executorService
        executorService = TtlExecutors.getTtlExecutorService(executorService);

        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

        // 在父线程中设置
        context.set("value-set-in-parent");
        executorService.submit(() -> {
            context.set("value-set-in-parent");
            String value = context.get();
            System.out.println("value-get-in-child:" + value);
        });

        //确保线程池任务执行完
        Thread.sleep(10);
        context.remove();

        context.set("value-set-in-parent 2");
        executorService.submit(() -> {
            // Task或是Call中可以读取，值是"value-set-in-parent 2"
            String value = context.get();
            System.out.println("value-get-in-child 2:" + value);
        });

        Thread.sleep(10);
        context.remove();
    }
}

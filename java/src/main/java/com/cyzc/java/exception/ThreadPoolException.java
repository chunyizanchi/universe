package com.cyzc.java.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/23 21:51]
 */
@Slf4j
public class ThreadPoolException {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

       // Future submit = executorService.submit(() -> test());
       /* try {
            submit.get();//调用get 之后出现堆栈异常，在最外层捕获没问题.会出现一个 ExecutionException.可以看futureTask的源码，由一段描述 判断FutureTask的状态决定返回什么，大于Cancel 返回的时CancelledException。其他就是ExecutionException
        } catch (Exception e) {
           e.printStackTrace();
        }*/

        //executorService.execute(()->test());// 没经过futureTask ，所以只返回runtime异常

        //keypoint 两者的区别
        // 1. 线程池里面task不捕获异常的话，FutureTask会帮我们捕获，并通过FutureTask的run#setException()放回到Future对象里，当我们调用Future.get的时候会获取异常,这时FutureTask的status=Exceptional,这时调用#get方法的时候会抛出
        // 2. 如果线程池类里task捕获异常的话，FutureTask就不会帮我们捕获异常了，通过FutureTask#run#set(result)放到Future对象里,之所以会打印异常，那是在子线程内try catch打印的。这时FutureTask的status=Normal，所以调用#get的时候不会抛出ExecutionException
        // 3. 向线程池提交任务的时候，如果拒绝执行，是不会创建 Worker对象的，自然也不会走FutureTask 中的#run方法，再分析一下，就很明显了。就是一个正常的处理流程。 我们没捕获异常，jvm会帮我们处理，在Thread类中setUncaughtException，这样一般是由调用线程抛出了。
        // why神将这情况引导到 jvm如何处理异常！！！  手动try catch和不 try catch有什么区别。
        Future submit = executorService.submit(() -> {

                test();

        });

        //<editor-fold desc="这里很奇怪啊">

        try {
            submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //</editor-fold>

    }
    public static void test() throws RuntimeException{
      log.info("线程："+Thread.currentThread().getName()+"===执行 test() 方法");
      throw  new RuntimeException("线程："+Thread.currentThread().getName()+"===出现异常");
    }

}

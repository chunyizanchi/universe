package com.cyzc.java.juc.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>则代表它是公平的策略，会把之前已经等待的线程放入到队列中，而当有新的许可证到来时，它会把这个许可证按照顺序发放给之前正在等待的线程；如果这个构造函数第二个参数传入
 * false，则代表非公平策略，也就有可能插队，就是说后进行请求的线程有可能先得到许可证
 *
 * @author Cyzc
 * @since [2021/12/31 10:48]
 */
public class SemaphoreDemo {

    static int clientCount = 3;
    static Semaphore semaphore = new Semaphore(clientCount, false);

    public static void main(String[] args) {

        //int permits, boolean fair

        ExecutorService service = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 1000; i++) {

            service.submit(new Task());

        }

        service.shutdown();

    }

    static class Task implements Runnable {

        @Override

        public void run() {

            try {
                //获取许可
                semaphore.acquire();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println(Thread.currentThread().getName() + "拿到了许可证，花费2秒执行慢服务");

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println("慢服务执行完毕，" + Thread.currentThread().getName() + "释放了许可证");
            //释放许可
            semaphore.release();

        }

    }

}

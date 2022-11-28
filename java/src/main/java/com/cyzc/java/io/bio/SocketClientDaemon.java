package com.cyzc.java.io.bio;

import java.util.concurrent.CountDownLatch;

/**
 * <p>模拟20个客户端并发请求，服务器端使用单线程:
 * 客户端代码(SocketClientDaemon)
 *
 * @author Cyzc
 * @since [2022/11/27 11:16]
 */
public class SocketClientDaemon {

    public static void main(String[] args) throws InterruptedException {
        //模拟的 客户端数量
        int clintNumBer=20;
        //使用 CountDownLatch 来
        CountDownLatch countDownLatch = new CountDownLatch(clintNumBer);
        //启动20个客户端
        for (int index = 0; index < clintNumBer; index++,countDownLatch.countDown()) {
            SocketClientRequestThread client = new SocketClientRequestThread(countDownLatch, index);
            new Thread(client).start();

        }
        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (SocketClientDaemon.class) {
            SocketClientDaemon.class.wait();
        }

    }

}

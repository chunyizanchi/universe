package com.cyzc.why.controller;

import cn.hutool.http.HttpUtil;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>  fixme 高并发下的请求合并
 *
 * @author Cyzc
 * @since [2022/01/10 15:59]
 */
@Slf4j
public class MainTest {

    public static void main(String[] args) throws InterruptedException {

       /* ExecutorService executorService = Executors.newFixedThreadPool(20);

        CountDownLatch countDownLatch = new CountDownLatch(20);

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    countDownLatch.await();

                    String response = HttpUtil.get(
                            "http://127.0.0.1:8082/studentByMerge/" + finalI);
                    System.out.println("response" + response);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();

        }

        Thread.currentThread().join();*/
        int i = (3 + 2) / 5;
        System.out.println(i);

    }
}

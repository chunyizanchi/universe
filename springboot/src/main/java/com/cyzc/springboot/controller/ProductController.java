package com.cyzc.springboot.controller;

import com.cyzc.springboot.service.SellService;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>why神@Transactionl 注解的demo
 *
 * @author Cyzc
 * @since [2022/08/11 16:25]
 */
@RestController
public class ProductController {

    @Autowired
    private SellService sellService;

    @GetMapping("sell")
    public void sell() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    sellService.sellProduct();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                ;
            }).start();

            countDownLatch.countDown();
        }

    }

}

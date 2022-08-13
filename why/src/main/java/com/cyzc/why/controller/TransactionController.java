package com.cyzc.why.controller;

import com.cyzc.why.entity.Prize;
import com.cyzc.why.service.SellService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/10 11:54]
 */
@RestController("/transaction")
public class TransactionController {

    @Autowired
    private SellService sellService;

    @GetMapping("/sell")
    public void sellProduct() {
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    sellService.sellProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }

    }

    @GetMapping("/drawPrize")
    public void drawPrize() {
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    final String threadName = Thread.currentThread().getName();
                    final Prize prize = sellService.drawPrize(1, threadName);
                    System.out.println(threadName + "抽到了" + prize);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }

    }

    @GetMapping(value = "/testException")
    public Map testExceptionHandle(){
        Prize p=new Prize();

        Map map=new HashMap();
        map.put("key","1111");
        map.put("value",p.getPrizeName().toLowerCase());
        return map;


    }

}

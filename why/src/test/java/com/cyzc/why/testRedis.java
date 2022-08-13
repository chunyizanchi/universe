package com.cyzc.why;

import com.cyzc.why.entity.Prize;
import com.cyzc.why.service.SellService;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/17 01:06]
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class testRedis {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SellService sellService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis() {
        final BoundValueOperations<String, String> testAuth = stringRedisTemplate.boundValueOps(
                "testAuth");
        //testAuth.set("hi");
        final String s = testAuth.get();
        assertEquals("hii",s);
        log.info("hello redis");
    }

    @Test
    public void testRedisDelete(){

        redisTemplate.delete("testAuth");
    }



    @Test
    public void testRedisTemplate() {
        Long number = redisTemplate.opsForList().leftPushAll("RedisTemplateOpsForList","1","2","3");
        log.info("hello redis",number);

    }
    @Test
    public void testStringRedisTemplate(){
        final Long stringRedisTemplateOpsForList = stringRedisTemplate.opsForList()
                .leftPushAll("StringRedisTemplateOpsForList", "4", "5", "6");
        System.out.println(stringRedisTemplateOpsForList);
    }


    @Test
    public void testSellService(){
        final Prize prize = sellService.drawPrize(1, "TEST");
        System.out.println(prize);
    }

    /**
     * 单元测试方法主线程执行完 jvm就退出了，所以无法测多线程
     * 1：主线程join 等待
     * 2：
     */
    @Test
    public void testThreadSellService() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    final String threadName = Thread.currentThread().getName();
                    final Prize prize = sellService.drawPrize(1, threadName);
                    System.out.println(threadName+"抽到了"+prize);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }
        Thread.currentThread().join();
    }

}

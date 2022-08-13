package com.cyzc.why.controller;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/29 22:52]
 */
@RestController
@RequestMapping("/redisson")
public class RedissionController {

    @Autowired
    private RedissonClient redissonClient;


    @GetMapping("/lockDemo")
    public void lockDemo() throws InterruptedException {
        RLock why = redissonClient.getLock("why");
        why.lock();
        TimeUnit.SECONDS.sleep(60);
        why.unlock();
    }
}

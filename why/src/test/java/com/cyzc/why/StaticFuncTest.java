package com.cyzc.why;

import com.cyzc.why.utils.WeChatConstant;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/25 14:31]
 */
public class StaticFuncTest {



    @Test
    public void test(){
        WeChatConstant.test();
    }

    @Test
    public void redissonLockTest() throws InterruptedException {
        Config config=new Config();
        config.useSingleServer().setAddress("39.108.136.133");
        config.setLockWatchdogTimeout(6000);
        RedissonClient redissonClient = Redisson.create(config);

        RLock rLock = redissonClient.getLock("why");
        rLock.lock();

        TimeUnit.SECONDS.sleep(60);

        rLock.unlock();
    }
}

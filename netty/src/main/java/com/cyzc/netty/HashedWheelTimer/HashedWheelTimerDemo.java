package com.cyzc.netty.HashedWheelTimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/25 22:35]
 */
public class HashedWheelTimerDemo {
    static HashedWheelTimer wheelTimer = new HashedWheelTimer();
    public static void main(String[] args) {
         watchDog();
    }

    public static void watchDog() {
        wheelTimer.newTimeout(timeout -> {
            System.out.println("我是看门狗,每隔3s 执行一次！:" + new Date());
            watchDog();
        }, 3, TimeUnit.SECONDS);
    }
}

package com.cyzc.java.guava.reflect;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/20 15:06]
 */
public class GuavaCache {

    public static void main(String[] args) throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            Thread.sleep(time * 1000);
            System.out.println(
                    "睡眠" + time++ + "秒后取到key1的值为：" + cache.getIfPresent("key1"));
        }
    }

}

package com.cyzc.why.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/16 23:47]
 */
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Object>  redisTemplate() {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        // 设置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置 key/value 的序列化策略
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 针对hash存储的key的序列化策略
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        // 开启事务支持
        redisTemplate.setEnableTransactionSupport(true);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);

        // 开启事务支持
        stringRedisTemplate.setEnableTransactionSupport(true);

        return stringRedisTemplate;
    }

}

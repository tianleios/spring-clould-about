package com.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class CacheConfig extends CachingConfigurerSupport {

//    @Resource
//    RedisTemplate redisTemplate;

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {

        return new RedisCacheManager(redisTemplate);

    }


}

package com.cache.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

//    @Autowired
//    CacheManager cacheManager;

//    @Autowired
//    ConcurrentMapCacheManager concurrentMapCacheManager;

//    @Autowired
//    RedisCacheManager redisCacheManager;

    //缓存让
    @Cacheable(cacheNames = "userInfo", key = "#userId")
    public String userInfo(String userId) {

        System.out.print("查询了一次");
        return "user:" + userId;

    }


    //该方法调用的时候就会清除缓存
    @CacheEvict(cacheNames = "userInfo", key = "#userId")
    public void clearCache(String userId) {


    }


}

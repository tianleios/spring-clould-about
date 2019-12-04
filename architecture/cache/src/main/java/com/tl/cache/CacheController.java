package com.tl.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianlei on 2019/9/8
 */
@RestController
@RequestMapping("/cache")
public class CacheController {


    private Integer count = 0;

    private LoadingCache<String, String> cache = Caffeine.newBuilder()
            .maximumSize(1)
            .expireAfterAccess(300, TimeUnit.SECONDS)
            .refreshAfterWrite(5, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Nullable
                @Override
                public String load(@NonNull String s) throws Exception {
                    System.out.println("刷新 - " + Thread.currentThread().getName()  + "-" + count);
                    return count.toString();
                }
            });


    @GetMapping("/get")
    String get() {
        System.out.println("get - b" + Thread.currentThread().getName()  + System.currentTimeMillis()/1000);
        String val = cache.get("key");
        System.out.println("get - after" + System.currentTimeMillis()/1000);

        return val;
    }

    @GetMapping("/add")
    void add() {
        count ++;
    }

}

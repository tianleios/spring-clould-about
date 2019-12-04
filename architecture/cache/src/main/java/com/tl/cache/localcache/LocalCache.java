package com.tl.cache.localcache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianlei on 2019-08-14
 */
public class LocalCache {

    public static void main(String[] args) throws Exception {

        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Nullable
                    @Override
                    public String load(@NonNull String s) throws Exception {
                        System.out.println("刷新");
                        return "value";
                    }
                });

        cache.get("key");


        while (1 > 0){

            if (0 > 1) {
                break;
            }
        }

        System.out.println("结束");


    }

}

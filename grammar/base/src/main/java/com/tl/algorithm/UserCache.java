package com.tl.algorithm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tianlei on 2019/1/5
 */
public class UserCache {


    public static class User {

        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    private ConcurrentHashMap<Long, User> cacheMap;
    private ConcurrentHashMap<Long, Long> expireMap;
    private final static Long INTERVAL = (long) (30 * 60 * 1000);
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public UserCache() {
        cacheMap = new ConcurrentHashMap<>();
        expireMap = new ConcurrentHashMap<>();
    }

    public User get(Long id) {

        lock.readLock().lock();
        User user;
        try {
            user = cacheMap.get(id);
        } finally {
            lock.readLock().unlock();
        }
        if (user == null) {
            user = getUserFromDB(id);
            reCache(user);
        } else {
            if (expireMap.get(id) >= System.currentTimeMillis()) {
                return user;
            } else {
                user = getUserFromDB(id);
                reCache(user);
            }
        }
        return user;
    }


    private void reCache(User user) {
        lock.writeLock().lock();
        try {
            cacheMap.put(user.getId(), user);
            expireMap.put(user.getId(), System.currentTimeMillis() + INTERVAL);
        } finally {
            lock.writeLock().lock();
        }
    }

    private User getUserFromDB(Long id) {

        User user = new User();
        user.setId(id);
        return user;

    }





    // ---------------- 真正题目条件
    /**
     * 初始化用户信息缓存
     */
    public void initUserInfoCache() {
        //: TODO 完成此处的代码
        if (null == cacheMap) {
            synchronized (this.getClass()) {
                if (null == cacheMap) {
                    cacheMap = new ConcurrentHashMap<>();
                    expireMap = new ConcurrentHashMap<>();
                }
            }
        }
    }

    /**
     * 根据id从缓存中获取用户信息
     */
    public User getUserInfoFromCacheById(String id) {
        //: TODO 完成此处的代码
        User user = this.cacheMap.get(Long.valueOf(id));
        if (user == null) {
            updateUserInfoCache(id);
            user = this.cacheMap.get(Long.valueOf(id));
        } else {

        }

        return user;

    }

    /**
     * 根据id更新缓存用户信息
     */
    public void updateUserInfoCache(String id) {
        //: TODO 完成此处的代码

//        this.expireMap.put(Long.valueOf(id), (long)(System.currentTimeMillis() + INTERVAL));
//        this.cacheMap.put()

    }

}

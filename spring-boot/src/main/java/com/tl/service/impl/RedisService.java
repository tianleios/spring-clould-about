package com.tl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

import java.util.*;

@Service
public class RedisService {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");

        //1.字符串
        {

            String name = jedis.get("name");
            //设置 60 s 过期
            jedis.expire("name", 60);

        }

        //2.Hash
        {
            String hashName = "myHash";

            Map hashMap = new HashMap();
            hashMap.put("name", "tianlei");
            hashMap.put("city", "sq");
            //设置
            jedis.hmset(hashName, hashMap);

            //获取所有
            Map all = jedis.hgetAll(hashName);

            // should tianeli
            jedis.hget(hashName, "name");

        }

        //3.List
        {
            String listName = "myList";
            jedis.lpush(listName, "red");
            jedis.lpush(listName, "blue");
            //获取指定范围内
            List all = jedis.lrange(listName, 0, 2);
            //获取单个
            String sign = jedis.lindex(listName, 0);

            //移除list
            jedis.lpop(listName);


        }

        //4.Set
        {
            String setName = "mySet";
            jedis.sadd(setName, "red");
            jedis.sadd(setName, "red");
            jedis.sadd(setName, "blue");

            // contain "red" "blue" 去重
            Set all = jedis.smembers(setName);


        }

        //5.Sorted set
        {
            String sortedSetName = "mySortedSet";
            jedis.zadd(sortedSetName, 0, "zero");
            jedis.zadd(sortedSetName, 1, "one");
            jedis.zadd(sortedSetName, 2, "two");

            // 根据 0 1 2 排序

            // contain "red" "blue" 去重
            Set all = jedis.zrange(sortedSetName, 0, 2);


        }

        //6.HyperLogLog
        {
            // 比如数据集 {1, 3, 5, 7, 5, 7, 8}，
            // 那么这个数据集的基数集为 {1, 3, 5 ,7, 8},
            // 基数(不重复元素)为5。 基数估计就是在误差可接受的范围内，快速计算基数。
        }

        //7.事件
        {
            String channleName = "chat";
            JedisPubSub pubSub = new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {

                }
            };
            jedis.subscribe(pubSub, channleName);
            jedis.publish(channleName, "msg");

        }

    }

    @Autowired
    JedisPool jedisPool;

    public String getValue(String key) {

        try (Jedis jedis = this.jedisPool.getResource()) {

            if (!jedis.exists(key)) {
                return null;
            }
            String value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean setValue(String key, String value) {

        return false;
    }


    public void cluster() {

        //创建一个集群
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        jedisClusterNodes.add(new HostAndPort("localhost", 6375));

        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
        jedisCluster.set("foo", "bar");
        String value = jedisCluster.get("foo");
    }

}

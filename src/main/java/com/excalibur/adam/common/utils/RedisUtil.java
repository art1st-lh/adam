package com.excalibur.adam.common.utils;

import redis.clients.jedis.JedisCluster;

import java.util.Map;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午2:17
 */
public class RedisUtil {

    public static void addHashMap(String key, Map hash, JedisCluster redis) {
        addHashMap(key,hash,-1, redis);
    }

    public static void addHashMap(String key, Map hash, int expireTime, JedisCluster redis) {
        redis.hmset(key,hash);
        redis.expire(key,expireTime);
    }

    public static Map getHashMap(String key, JedisCluster redis) {
        return redis.hgetAll(key);
    }

    public static String getHashMapByField(String key, String field, JedisCluster redis) {
        return redis.hget(key,field);
    }

    public static void pushStack(JedisCluster redis, String key, String... values) {
        for (String value : values) {
            redis.lpush(key,value);
        }
    }

    public static String popStack(String key, JedisCluster redis) {
        return redis.lpop(key);
    }

    public void enqueue(JedisCluster redis, String key, String... values) {
        for (String value : values) {
            redis.lpush(key,value);
        }
    }

    public static String dequeue(String key, JedisCluster redis) {
        return redis.rpop(key);
    }

    public static void setString(String phoneNo, String s, int otpValidSec, JedisCluster redis) {
        redis.set(phoneNo, s);
        redis.expire(phoneNo, otpValidSec);
    }
}

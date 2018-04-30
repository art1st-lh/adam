package com.excalibur.adam.common.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午1:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void get(){
        System.out.println("=============="+jedisCluster.get("name"));
    }

}

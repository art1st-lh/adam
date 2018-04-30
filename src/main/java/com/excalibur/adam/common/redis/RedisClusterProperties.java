package com.excalibur.adam.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午1:07
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisClusterProperties {

    private List<String> nodes = new ArrayList<>();

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
package com.excalibur.adam.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午3:52
 */
@Configuration
@ConfigurationProperties(prefix = "spring.rsa")
public class RSAProperties {

    private String publicKey = null;

    private String privateKey = null;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}

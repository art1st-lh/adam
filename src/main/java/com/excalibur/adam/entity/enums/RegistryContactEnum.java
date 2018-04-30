package com.excalibur.adam.entity.enums;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午10:29
 */
public enum RegistryContactEnum {
    MSG("00","短信验证"),
    EMAIL("01","邮箱验证"),
    WE_CHAT("02","微信验证");

    private String code;
    private String desc;

    RegistryContactEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

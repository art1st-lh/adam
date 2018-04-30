package com.excalibur.adam.common.response;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:11
 */
public enum ResponseEnum {

    SUCCESS("00","OK"),
    ERROR("01","ERROR"),
    BUSINESS_EXCEPTION("02",""),

    ILLEGAL_PHONE_NO("0001","非法手机号"),
    ILLEGAL_OTP("0002","验证码错误"),
    ILLEGAL_CONTACT("0003","请输入手机号或邮箱"),
    ILLEGAL_EMAIL("0004","非法邮箱地址"),
    ILLEGAL_PARAMS("0005","参数非法"),
    OTP_OUT_OF_DATE("0006","验证码已过期，请重新获取"),
    DECRYPT_ERROR("0007","解密异常"),

    NO_NEIGHBORS("0008","暂未找到附近的人");


    private String code;
    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

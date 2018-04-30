package com.excalibur.adam.common.exception;

import com.excalibur.adam.common.response.ResponseEnum; /**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:26
 */
public class BusinessException extends Exception {

    private String code;
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(ResponseEnum r) {
        this.code = r.getCode();
        this.message = r.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

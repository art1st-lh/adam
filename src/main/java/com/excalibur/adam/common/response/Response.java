package com.excalibur.adam.common.response;

import com.excalibur.adam.common.exception.BusinessException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:13
 */
public class Response<T> {

    private T data;

    public Response(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                '}';
    }

    public static <T> Map success(T data) {
        Map result = new HashMap();
        result.put("DATA",data);
        result.put("CODE",ResponseEnum.SUCCESS.getCode());
        result.put("MSG",ResponseEnum.SUCCESS.getMsg());
        return result;
    }

    public static Map success() {
        Map result = new HashMap();
        result.put("CODE",ResponseEnum.SUCCESS.getCode());
        result.put("MSG",ResponseEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> Map error(T data) {
        Map result = new HashMap();
        if (data instanceof ResponseEnum) {
            result.put("CODE",((ResponseEnum) data).getCode());
            result.put("MSG",((ResponseEnum) data).getMsg());
        } else if (data instanceof BusinessException){
            result.put("CODE",((BusinessException) data).getCode());
            result.put("MSG",((BusinessException) data).getMessage());
        } else {
            result.put("DATA",data);
            result.put("CODE",ResponseEnum.ERROR.getCode());
            result.put("MSG",ResponseEnum.ERROR.getMsg());
        }
        return result;
    }

    public static Map error() {
        Map result = new HashMap();
        result.put("CODE",ResponseEnum.ERROR.getCode());
        result.put("MSG",ResponseEnum.ERROR.getMsg());
        return result;
    }
}

package com.excalibur.adam.common.utils;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午10:12
 */
public class StringUtil {

    public static boolean isBlank(String str) {
        return str == null || "".equals(str) || "".equals(str.trim());
    }
}

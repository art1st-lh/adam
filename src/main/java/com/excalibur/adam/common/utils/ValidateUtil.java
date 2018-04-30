package com.excalibur.adam.common.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:56
 */
public class ValidateUtil {

    private final static String REGEX_PHONE_NO = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

    private final static String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private final static String REGEX_OTP_MSG = "^\\d{6}$";

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isLegalPhoneNo(String phoneNo) {
        return regexMatcher(REGEX_PHONE_NO, phoneNo);
    }

    public static boolean isLegalEmailAddress(String email) {
        return regexMatcher(REGEX_EMAIL, email);
    }

    public static boolean isLegalOTP(String otpMsg) {
        if (StringUtil.isBlank(otpMsg)) {
            return false;
        }
        return regexMatcher(REGEX_OTP_MSG, otpMsg);
    }

    public static boolean regexMatcher(String regexFormat, String regex) {
        Matcher matcher = Pattern.compile(regexFormat).matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isLegalOTP("123567"));
        System.out.println(isLegalPhoneNo("13429774945"));
        System.out.println(isLegalPhoneNo("134297749459"));
        System.out.println(isLegalPhoneNo("1342977494x"));
        System.out.println(isLegalPhoneNo("2342977494x"));
        System.out.println(isLegalEmailAddress("123567"));
        System.out.println(isLegalEmailAddress("123567@123.com"));
        System.out.println(isLegalEmailAddress("123567@123"));
        System.out.println(isLegalEmailAddress("123567.com"));
    }
}

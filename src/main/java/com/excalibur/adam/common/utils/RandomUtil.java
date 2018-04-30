package com.excalibur.adam.common.utils;

import java.util.Random;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午2:49
 */
public class RandomUtil {

    public static String generateRandomOtpCode() {
        String sources = "0123456789";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < 6; j++)
        {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return flag.toString();
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++)
        System.out.println(generateRandomOtpCode());
    }
}

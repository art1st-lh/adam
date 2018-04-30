package com.excalibur.adam.service.impl;

import com.excalibur.adam.common.exception.BusinessException;
import com.excalibur.adam.common.response.ResponseEnum;
import com.excalibur.adam.common.utils.RandomUtil;
import com.excalibur.adam.common.utils.RedisUtil;
import com.excalibur.adam.common.utils.StringUtil;
import com.excalibur.adam.common.utils.ValidateUtil;
import com.excalibur.adam.entity.constants.RedisConstant;
import com.excalibur.adam.entity.enums.RegistryContactEnum;
import com.excalibur.adam.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午9:35
 */
public class CommonServiceImpl implements CommonService {

    @Autowired
    JedisCluster redis;

    @Override
    public void sendMsg(String phoneNo) {
        RedisUtil.setString(phoneNo, RandomUtil.generateRandomOtpCode(), RedisConstant.OTP_VALID_SEC,redis);
    }

    @Override
    public void sendEmail(String userContact) {

    }

    @Override
    public void verifyOTP(String otpMsg, String contact, String registryType) throws BusinessException {

        if (StringUtil.isBlank(registryType)) {
            throw new BusinessException(ResponseEnum.ILLEGAL_PARAMS);
        }

        if (registryType.equals(RegistryContactEnum.MSG.getCode())) {
            verifyMsg(otpMsg, contact);
        } else if (registryType.equals(RegistryContactEnum.EMAIL.getCode())) {
            verifyEmail(otpMsg, contact);
        }

    }

    private void verifyMsg(String otpMsg, String phoneNo) throws BusinessException {
        if (!ValidateUtil.isLegalPhoneNo(phoneNo)) {
            throw new BusinessException(ResponseEnum.ILLEGAL_PHONE_NO);
        }

        if (!ValidateUtil.isLegalOTP(otpMsg)) {
            throw new BusinessException(ResponseEnum.ILLEGAL_OTP);
        }

        String cacheOTP = redis.get(phoneNo);

        if (StringUtil.isBlank(cacheOTP)) {
            throw new BusinessException(ResponseEnum.OTP_OUT_OF_DATE);
        }

        if (!otpMsg.equals(cacheOTP)) {
            throw new BusinessException(ResponseEnum.ILLEGAL_OTP);
        }
    }

    private void verifyEmail(String otpMsg, String contact) {
    }

}

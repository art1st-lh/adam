package com.excalibur.adam.service;

import com.excalibur.adam.common.exception.BusinessException;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午9:35
 */
public interface CommonService {

    void sendMsg(String phoneNo);

    void sendEmail(String userContact);

    void verifyOTP(String otpMsg, String userId, String registryType) throws BusinessException;

}

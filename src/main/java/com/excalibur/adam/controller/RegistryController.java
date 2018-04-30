package com.excalibur.adam.controller;

import com.excalibur.adam.common.exception.BusinessException;
import com.excalibur.adam.common.response.Response;
import com.excalibur.adam.common.response.ResponseEnum;
import com.excalibur.adam.common.utils.RSAUtil;
import com.excalibur.adam.common.utils.StringUtil;
import com.excalibur.adam.common.utils.ValidateUtil;
import com.excalibur.adam.entity.User;
import com.excalibur.adam.entity.enums.RegistryContactEnum;
import com.excalibur.adam.service.CommonService;
import com.excalibur.adam.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:40
 */
@RestController
@RequestMapping(value = "/registry")
public class RegistryController {

    @Autowired
    private RegistryService registryService;

    @Autowired
    private CommonService commonService;

    @ResponseBody
    @RequestMapping(value = "/sendVerifyInfo", produces = {"application/json;charset=UTF-8"})
    public Object sendVerifyInfo(String userContact, String type) {
        if (StringUtil.isBlank(type)) {
            return Response.error(ResponseEnum.ILLEGAL_CONTACT);
        }

        try {
            if (type.equals(RegistryContactEnum.MSG.getCode())) {
                if (!ValidateUtil.isLegalPhoneNo(userContact)) {
                    return Response.error(ResponseEnum.ILLEGAL_PHONE_NO);
                }
                commonService.sendMsg(userContact);
            } else if (type.equals(RegistryContactEnum.EMAIL.getCode())) {
                if (!ValidateUtil.isLegalPhoneNo(userContact)) {
                    return Response.error(ResponseEnum.ILLEGAL_EMAIL);
                }
                commonService.sendEmail(userContact);
            } else
                return Response.error();
        } catch (Exception e) {
            return Response.error();
        }

        return Response.success();
    }

    @RequestMapping(value = "/verifyOTP", produces = {"application/json;charset=UTF-8"})
    public Object verifyOTP(String otpMsg, String registryType, String phoneNo) {
        phoneNo = RSAUtil.decrypt(phoneNo);
        if (StringUtil.isBlank(phoneNo)) {
            return Response.error(ResponseEnum.DECRYPT_ERROR);
        }
        try {
            commonService.verifyOTP(otpMsg,phoneNo,registryType);
        } catch (BusinessException e) {
            return Response.error(e);
        }
        return Response.success();
    }

    @RequestMapping(value = "/register", produces = {"application/json;charset=UTF-8"})
    public Object register(User user) {
        registryService.register(user);
        return Response.success();
    }

}

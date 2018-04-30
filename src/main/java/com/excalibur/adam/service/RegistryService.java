package com.excalibur.adam.service;

import com.excalibur.adam.common.exception.BusinessException;
import com.excalibur.adam.entity.User;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:41
 */
public interface RegistryService {

    void register(User user);

    void registerByOpenId(User user);

}

package com.excalibur.adam.service.impl;

import com.excalibur.adam.entity.User;
import com.excalibur.adam.mapper.UserMapper;
import com.excalibur.adam.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午9:42
 */
@Service(value = "registryService")
public class RegistryServiceImpl implements RegistryService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void registerByOpenId(User user) {

    }

}

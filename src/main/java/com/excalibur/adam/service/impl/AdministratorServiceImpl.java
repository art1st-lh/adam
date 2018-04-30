package com.excalibur.adam.service.impl;

import com.excalibur.adam.entity.User;
import com.excalibur.adam.mapper.UserMapper;
import com.excalibur.adam.service.AdministratorService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午8:13
 */
@Service(value = "administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public void modifyPassword(String password, User user) {
        //TODO
    }

    @Override
    public void modifyPhone(String phone, User user) {
        //TODO
    }

    @Override
    public void deleteUserByUid(int userId) {
        //TODO
    }

    @Override
    public void batchAddUser(List<User> users) {
        //TODO
    }
}

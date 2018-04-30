package com.excalibur.adam.service;

import com.excalibur.adam.common.exception.BusinessException;
import com.excalibur.adam.entity.User;

import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午8:13
 */
public interface AdministratorService {

    void addUser(User user) throws BusinessException;

    List<User> findAllUser(int pageNum, int pageSize) throws BusinessException;

    void modifyPassword(String password, User user) throws BusinessException;

    void modifyPhone(String phone, User user) throws BusinessException;

    void deleteUserByUid(int userId) throws BusinessException;

    void batchAddUser(List<User> users) throws BusinessException;

}

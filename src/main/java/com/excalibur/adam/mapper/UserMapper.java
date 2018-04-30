package com.excalibur.adam.mapper;

import com.excalibur.adam.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午8:10
 */
@Mapper
public interface UserMapper {

    void deleteByPrimaryKey(Integer userId);

    void insert(User record);

    void insertSelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();
}

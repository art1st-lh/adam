package com.excalibur.adam.controller;

import com.excalibur.adam.common.exception.BusinessException;
import com.excalibur.adam.common.response.Response;
import com.excalibur.adam.entity.User;
import com.excalibur.adam.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/29
 * @Time: 下午8:14
 */
@RestController
@RequestMapping(value = "/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Object addUser(User user) {
        try {
            administratorService.addUser(user);
        } catch (BusinessException e) {
            return Response.error();
        }
        return Response.success();
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        List<User> users = null;
        try {
            users = administratorService.findAllUser(pageNum,pageSize);
        } catch (BusinessException e) {
            return Response.error();
        }
       return Response.success(users);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPassword", produces = {"application/json;charset=UTF-8"})
    public Object modifyPassword(@RequestParam("password") String password, User user) {
        return Response.error("暂未开发");
    }
}

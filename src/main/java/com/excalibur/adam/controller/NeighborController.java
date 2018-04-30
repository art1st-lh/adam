package com.excalibur.adam.controller;

import com.excalibur.adam.common.response.Response;
import com.excalibur.adam.common.response.ResponseEnum;
import com.excalibur.adam.common.utils.ListUtil;
import com.excalibur.adam.entity.Neighbor;
import com.excalibur.adam.entity.UserAddress;
import com.excalibur.adam.service.NeighborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午9:32
 */
@RestController
@RequestMapping(value = "/neighbor")
public class NeighborController {

    @Autowired
    private NeighborService neighborService;

    @ResponseBody
    @RequestMapping(value = "/findNeighbors", produces = {"application/json;charset=UTF-8"})
    public Object findNeighbors(UserAddress userAddress) {
        List<Neighbor> neighbors = neighborService.findNeighbors(userAddress);
        if (ListUtil.isEmpty(neighbors)) {
            return Response.error(ResponseEnum.NO_NEIGHBORS);
        }
        return Response.success(neighbors);
    }

}

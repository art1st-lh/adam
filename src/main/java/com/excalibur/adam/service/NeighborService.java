package com.excalibur.adam.service;

import com.excalibur.adam.entity.Neighbor;
import com.excalibur.adam.entity.UserAddress;

import java.util.List;

/**
 * @Author: Created by lh.
 * @Date: 18/4/30
 * @Time: 下午9:22
 */
public interface NeighborService {

    List<Neighbor> findNeighbors(UserAddress userAddress);

    void sayHello(String msg);

    void sendFriendInvent();

}

package com.excalibur.adam.sao.autonavi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.excalibur.adam.common.config.constant.Constants;
import com.excalibur.adam.entity.UserAddress;
import com.excalibur.adam.entity.constants.HttpUrlConstant;
import com.excalibur.adam.entity.loc.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Created by lh.
 * @Date: 18/5/1
 * @Time: 上午1:02
 */
@Service("autoNaviMapService")
public class AutoNaviMapServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    public Address convertAddress(UserAddress userAddress) {
        Address address = null;
        Map params = new HashMap<>();
        params.put("address",userAddress.getAddress());
        params.put("output","JSON");
        params.put("key", Constants.AUTO_NAVI_KEY);
        params.put("province", userAddress.getCity());
        params.put("city",userAddress.getCity());
        params.put("district",userAddress.getDistrict());
        Object autoNaviResult = restTemplate.postForEntity(HttpUrlConstant.URL_CONVERT_COOR, params, JSONObject.class).getBody();
        address = JSON.parseObject(JSON.toJSONString(autoNaviResult),Address.class);
        return address;
    }


}

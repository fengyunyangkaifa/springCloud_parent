package com.usian.controller;

import com.alibaba.fastjson.JSONObject;
import com.usian.dto.AddTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@SuppressWarnings("ALL")
public class ConsumerController {

    //从Nacos注册中心获取服务端的ip、端口、要调用的服务
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //访问Rest服务的客户端
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value="teacher/insert")
    public Map getUserBy(@RequestBody AddTs addTs){
        ServiceInstance si = loadBalancerClient.choose("nacos-provider");
        //指定要调用的服务
        String url = "http://"+si.getHost()+":"+si.getPort()+"/insert";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        // 设置内容
        HttpEntity<AddTs> formEntity = new HttpEntity<AddTs>(addTs,headers);
        restTemplate.postForObject(url, formEntity, String.class);
        Map map=new HashMap();
        map.put("result",true);
        return map;
    }
}

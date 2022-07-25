package com.usian.controller;

import com.usian.dto.AddTs;
import com.usian.pojo.Student;
import com.usian.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@SuppressWarnings("ALL")
public class TeacherController {
    //从Nacos注册中心获取服务端的ip、端口、要调用的服务
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //访问Rest服务的客户端
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/insert")
    public void getUserBy(@RequestBody AddTs addTs){
//         添加教师
        teacherService.insert(addTs);
        ServiceInstance si = loadBalancerClient.choose("nacos-provider1");
        //指定要调用的服务
        String url = "http://"+si.getHost()+":"+si.getPort()+"/insert";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        // 设置内容
        HttpEntity<AddTs> formEntity = new HttpEntity<AddTs>(addTs,headers);
        restTemplate.postForObject(url, formEntity, String.class);
    }
}

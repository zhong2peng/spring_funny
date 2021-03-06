package com.dnight.cloud.customer.controller;

import com.dnight.cloud.customer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        System.out.println("consumer");
        return restTemplate.getForObject("http://zuul-provider-user/user/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public String logUserInstance() {
        return UUID.randomUUID().toString();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user-ribbon");
//        return String.format("%s:%s:%s", serviceInstance.getServiceId(),
//                serviceInstance.getHost(), serviceInstance.getPort());
    }

}

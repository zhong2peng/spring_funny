package com.dnight.cloud.customer.controller;

import com.dnight.cloud.customer.entity.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: dnight
 * Date: 2019/9/11 23:41
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User fingById(@PathVariable Long id){
        return restTemplate.getForObject("http://localhost:8010/user/" + id, User.class);
    }
}

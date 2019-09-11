package com.dnight.cloud.customer.controller;

import com.dnight.cloud.customer.entity.User;
import com.dnight.cloud.customer.repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Author: dnight
 * Date: 2019/9/11 23:32
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        Optional<User> byId = userRepository.findById(id);
        return byId.get();
    }
}

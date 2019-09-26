package com.dnight.cloud.customer.controller;

import com.dnight.cloud.customer.entity.User;
import com.dnight.cloud.customer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        User one = userRepository.getOne(id);
        return one;
    }
}

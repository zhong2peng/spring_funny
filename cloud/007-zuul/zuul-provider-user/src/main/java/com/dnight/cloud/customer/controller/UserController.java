package com.dnight.cloud.customer.controller;

import com.dnight.cloud.customer.entity.User;
import com.dnight.cloud.customer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
        System.out.println("provider");
        return one;
    }

    @PostMapping("/user/post")
    public User post(@RequestBody User user){
        System.out.println("provider"+user.getId());
        return user;
    }

    @PostMapping(value = "/upload")
    String handleFileUpload(@RequestParam(value = "file")MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }
}

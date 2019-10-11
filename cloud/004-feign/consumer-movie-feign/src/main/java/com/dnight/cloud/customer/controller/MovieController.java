package com.dnight.cloud.customer.controller;

import com.dnight.cloud.customer.entity.User;
import com.dnight.cloud.customer.feign.UserFeignClient;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://provider-user-ribbon/user/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public String logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user-ribbon");
        return String.format("%s:%s:%s", serviceInstance.getServiceId(),
                serviceInstance.getHost(), serviceInstance.getPort());
    }

    @GetMapping("/user/get0")
    public User get0(@RequestBody User user){
        return this.userFeignClient.get0(user);
    }

    @GetMapping("/user/get1/{id}")
    public User get1(@PathVariable Long id){
        return this.userFeignClient.get1(id);
    }

    @PostMapping("/user/post")
    public User post(@RequestBody User user){
        return this.userFeignClient.post(user);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return this.userFeignClient.handleFileUpload(file);
    }

}

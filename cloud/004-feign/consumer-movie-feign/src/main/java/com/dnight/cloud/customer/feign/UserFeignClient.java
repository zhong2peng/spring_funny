package com.dnight.cloud.customer.feign;

import com.dnight.cloud.customer.config.UserCenterFeignConfig;
import com.dnight.cloud.customer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
@FeignClient(name = "provider-user-feign", configuration = UserCenterFeignConfig.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/get")
    User get0(User user);

    @GetMapping(value = "/user/{id}")
    User get1(@PathVariable("id") Long id);

    @PostMapping(value = "/user/post")
    User post(@RequestBody User user);

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart("file") MultipartFile file);
}

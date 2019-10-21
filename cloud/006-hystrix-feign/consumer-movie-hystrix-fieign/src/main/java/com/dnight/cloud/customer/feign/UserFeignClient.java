package com.dnight.cloud.customer.feign;

import com.dnight.cloud.customer.entity.User;
import com.dnight.cloud.customer.service.FeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
@FeignClient(name = "provider-user-feign", configuration = FeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/get/{id}")
    User get0(@PathVariable Long id);

}

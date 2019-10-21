package com.dnight.cloud.customer.service;

import com.dnight.cloud.customer.entity.User;
import com.dnight.cloud.customer.feign.UserFeignClient;

/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User get0(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default");

        return user;
    }


}

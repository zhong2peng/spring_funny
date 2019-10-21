package com.dnight.cloud.customer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class UserCenterFeignConfig {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}

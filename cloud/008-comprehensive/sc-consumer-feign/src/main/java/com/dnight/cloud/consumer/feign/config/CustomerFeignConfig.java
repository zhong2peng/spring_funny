package com.dnight.cloud.consumer.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHONGPENG769
 * @date 2019/10/21
 */
@Configuration
public class CustomerFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}

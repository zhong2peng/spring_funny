package com.dnight.cloud.consumer.feign.client;

import com.dnight.cloud.consumer.feign.config.CustomerFeignConfig;
import com.dnight.cloud.consumer.feign.fallback.CustomerFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/21
 */
@FeignClient(name = "sc-provider", fallback = CustomerFeignClientFallback.class,
        configuration = CustomerFeignConfig.class)
public interface ConsumerFeignClient {

    @GetMapping("test/{msg}")
    String sayHelloWorld(@PathVariable("msg") String msg);

    @GetMapping("test/list")
    List<Integer> list();

    @GetMapping("test/list")
    Integer[] array();

}

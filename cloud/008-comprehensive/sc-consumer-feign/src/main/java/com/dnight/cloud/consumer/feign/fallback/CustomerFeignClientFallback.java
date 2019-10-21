package com.dnight.cloud.consumer.feign.fallback;

import com.dnight.cloud.consumer.feign.client.ConsumerFeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/21
 */
@Component
public class CustomerFeignClientFallback implements ConsumerFeignClient {
    @Override
    public String sayHelloWorld(String msg) {
        return "fallback";
    }

    @Override
    public List<Integer> list() {
        return new ArrayList<>();
    }

    @Override
    public Integer[] array() {
        return new Integer[0];
    }
}

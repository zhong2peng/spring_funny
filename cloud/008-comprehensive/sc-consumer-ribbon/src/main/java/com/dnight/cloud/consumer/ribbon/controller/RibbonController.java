package com.dnight.cloud.consumer.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

/**
 * @author ZHONGPENG769
 * @date 2019/10/21
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${demo.title:gggg}")
    private String remoteConfig;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("ribbon/{wd}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public Mono<String> sayHelloWorld(@PathVariable("wd") String parm){
        String res = this.restTemplate.getForObject("http://sc-provider/test/" + parm, String.class);
        return Mono.just("RemoteConfig: "+remoteConfig+" | "+res);
    }

    public Mono<String> fallbackMethod(@PathVariable String parm){
        return Mono.just("ribbon fallbackMethod "+parm);
    }
}

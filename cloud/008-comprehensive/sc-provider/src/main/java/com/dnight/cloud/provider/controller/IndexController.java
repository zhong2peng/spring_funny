package com.dnight.cloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/21
 */
@RestController
@RequestMapping("test")
public class IndexController {

    @GetMapping("{msg}")
    public Mono<String> sayHelloWorld(@PathVariable("msg") String msg){
        System.out.println("come on "+msg);
        return Mono.just("sc-provider receive : "+msg);
    }

    @GetMapping("list")
    public Flux<Integer> list(){
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(22);
        list.add(75);
        list.add(93);
        Flux<Integer> userFlux = Flux.fromIterable(list);
        return userFlux;
    }
}

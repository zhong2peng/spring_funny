package com.dnight.cloud.gateway.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHONGPENG769
 * @date 2019/10/22
 */
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public String fallback() {
        return "Hello World! from gateway";
    }
}

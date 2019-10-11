package com.dnight.cloud.customer.controller;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class PingTest implements IPing {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("ping机制");
        return false;
    }
}

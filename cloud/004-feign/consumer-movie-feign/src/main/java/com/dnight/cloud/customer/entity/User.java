package com.dnight.cloud.customer.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
@Data
public class User {

    private Long       id;
    private String     username;
    private String     name;
    private Integer    age;
    private BigDecimal balance;
}

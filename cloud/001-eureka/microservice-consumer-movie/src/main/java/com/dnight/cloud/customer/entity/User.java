package com.dnight.cloud.customer.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: dnight
 * Date: 2019/9/11 23:40
 */
@Data
public class User {

    private Long       id;
    private String     username;
    private String     name;
    private Integer    age;
    private BigDecimal balance;
}

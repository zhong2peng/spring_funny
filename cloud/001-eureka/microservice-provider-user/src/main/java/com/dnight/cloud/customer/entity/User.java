package com.dnight.cloud.customer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Author: dnight
 * Date: 2019/9/11 23:28
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    @Column
    private String     username;
    @Column
    private String     name;
    @Column
    private Integer    age;
    @Column
    private BigDecimal balance;
}

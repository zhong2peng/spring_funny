package com.dnight.cloud.customer.repository;

import com.dnight.cloud.customer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

package com.dnight.cloud.customer.repository;

import com.dnight.cloud.customer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

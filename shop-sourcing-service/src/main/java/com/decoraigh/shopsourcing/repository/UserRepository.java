package com.decoraigh.shopsourcing.repository;

import com.decoraigh.shopsourcing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
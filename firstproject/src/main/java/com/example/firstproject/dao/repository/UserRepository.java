package com.example.firstproject.dao.repository;

import com.example.firstproject.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);   // jpa query method
}

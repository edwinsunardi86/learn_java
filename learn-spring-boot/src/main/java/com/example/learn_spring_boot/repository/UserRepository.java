package com.example.learn_spring_boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn_spring_boot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}

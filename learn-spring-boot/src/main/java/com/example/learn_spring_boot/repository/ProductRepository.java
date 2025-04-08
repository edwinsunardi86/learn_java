package com.example.learn_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learn_spring_boot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

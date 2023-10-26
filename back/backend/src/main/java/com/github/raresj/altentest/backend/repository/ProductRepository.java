package com.github.raresj.altentest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.raresj.altentest.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}

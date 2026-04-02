package com.backend.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

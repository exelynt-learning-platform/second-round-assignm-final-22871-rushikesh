package com.backend.ecommerce.repository;

import com.backend.ecommerce.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByUsername(String username);
}
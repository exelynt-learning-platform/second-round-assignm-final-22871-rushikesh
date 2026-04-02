package com.backend.ecommerce.repository;

import com.backend.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUsername(String username);

    Optional<Cart> findByUsernameAndProductId(String username, Long productId);
}
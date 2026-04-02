package com.backend.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Long productId;

    private int quantity;

    public Cart() {}

    public Cart(String username, Long productId, int quantity) {
        this.username = username;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public Long getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setProductId(Long productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
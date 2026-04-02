package com.backend.ecommerce.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Long productId;
    private int quantity;

    private LocalDateTime orderDate;

    private String status;
    private String paymentId;

    public Orders() {}

    public Orders(String username, Long productId, int quantity, LocalDateTime orderDate, String status) {
        this.username = username;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public Long getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public String getPaymentId() { return paymentId; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setProductId(Long productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public void setStatus(String status) { this.status = status; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
}
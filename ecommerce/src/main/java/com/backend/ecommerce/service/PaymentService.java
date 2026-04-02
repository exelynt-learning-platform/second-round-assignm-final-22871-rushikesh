package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Orders;
import com.backend.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private final OrderRepository orderRepository;

    public PaymentService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processPayment(Long orderId) {

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        String paymentId = UUID.randomUUID().toString();

        order.setStatus("SUCCESS");
        order.setPaymentId(paymentId);

        orderRepository.save(order);

        return paymentId;
    }
}
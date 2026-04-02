package com.backend.ecommerce.controller;

import com.backend.ecommerce.entity.Orders;
import com.backend.ecommerce.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public List<Orders> placeOrder(Authentication auth) {
        return orderService.placeOrder(auth.getName());
    }

    @GetMapping
    public List<Orders> getOrders(Authentication auth) {
        return orderService.getOrders(auth.getName());
    }
}
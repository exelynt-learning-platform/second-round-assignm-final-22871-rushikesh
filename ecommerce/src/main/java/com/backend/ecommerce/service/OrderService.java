package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Cart;
import com.backend.ecommerce.entity.Orders;
import com.backend.ecommerce.repository.CartRepository;
import com.backend.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    public OrderService(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    public List<Orders> placeOrder(String username) {

        List<Cart> cartItems = cartRepository.findByUsername(username);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        List<Orders> orders = cartItems.stream().map(item ->
                new Orders(
                        username,
                        item.getProductId(),
                        item.getQuantity(),
                        LocalDateTime.now(),
                        "PENDING"
                )
        ).toList();

        orderRepository.saveAll(orders);

        cartRepository.deleteAll(cartItems);

        return orders;
    }

    public List<Orders> getOrders(String username) {
        return orderRepository.findByUsername(username);
    }
}
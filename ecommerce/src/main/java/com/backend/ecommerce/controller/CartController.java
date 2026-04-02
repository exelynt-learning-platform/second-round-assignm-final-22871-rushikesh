package com.backend.ecommerce.controller;

import com.backend.ecommerce.entity.Cart;
import com.backend.ecommerce.service.CartService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long productId,
                         @RequestParam int quantity,
                         Authentication auth) {

        String username = auth.getName();
        return cartService.addToCart(username, productId, quantity);
    }

    @GetMapping
    public List<Cart> getCart(Authentication auth) {
        return cartService.getCart(auth.getName());
    }
}
package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Cart;
import com.backend.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(String username, Long productId, int quantity) {

        Cart cart = cartRepository
                .findByUsernameAndProductId(username, productId)
                .orElse(null);

        if (cart != null) {
            cart.setQuantity(cart.getQuantity() + quantity);
        } else {
            cart = new Cart(username, productId, quantity);
        }

        return cartRepository.save(cart);
    }

    public List<Cart> getCart(String username) {
        return cartRepository.findByUsername(username);
    }
}
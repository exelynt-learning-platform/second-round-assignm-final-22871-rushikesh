package com.backend.ecommerce.controller;

import com.backend.ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{orderId}")
    public String pay(@PathVariable Long orderId) {
        return paymentService.processPayment(orderId);
    }
}
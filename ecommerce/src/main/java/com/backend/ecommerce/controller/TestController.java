package com.backend.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/any-secure-api")
    public String secureApi() {
        return "This is secured API";
    }
}

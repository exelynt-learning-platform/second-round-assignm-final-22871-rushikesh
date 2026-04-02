package com.backend.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ecommerce.dto.AuthRequest;
import com.backend.ecommerce.security.JwtUtil;
import com.backend.ecommerce.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	 private final JwtUtil jwtUtil;
	 private final AuthService authService;
	 
	 public AuthController(AuthService authService, JwtUtil jwtUtil) {
	     this.authService = authService;
	     this.jwtUtil = jwtUtil;
	 }
	 
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        System.out.println("REGISTER API HIT");
        System.out.println("AuthService = " + authService);

        authService.register(request.getUsername(), request.getPassword());
        
        return "User registered successfully";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        authService.authenticate(request.getUsername(), request.getPassword());
        return jwtUtil.generateToken(request.getUsername());
    }
}
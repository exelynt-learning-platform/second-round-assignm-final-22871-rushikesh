package com.backend.ecommerce.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public JwtFilter(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/auth"); // skip login/register
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("JWT FILTER HIT: " + request.getServletPath());

        String header = request.getHeader("Authorization");
        System.out.println("HEADER: " + header);

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);
            System.out.println("TOKEN: " + token);

            try {
                String username = jwtUtil.extractUsername(token);
                System.out.println("USERNAME: " + username);

                var userDetails = userDetailsService.loadUserByUsername(username);
                System.out.println("USER DETAILS: " + userDetails);

                if (jwtUtil.validateToken(token, username)) {
                    System.out.println("TOKEN VALID ✅");

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    System.out.println("TOKEN INVALID ❌");
                }

            } catch (Exception e) {
                System.out.println("JWT ERROR: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
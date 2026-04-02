package com.backend.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.backend.ecommerce.dto.ProductRequest;
import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted";
    }
}
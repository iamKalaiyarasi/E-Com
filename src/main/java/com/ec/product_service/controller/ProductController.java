package com.ec.product_service.controller;

import com.ec.product_service.entity.Product;
import com.ec.product_service.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //create product

    @PostMapping
    public Product addProduct(@RequestBody Product product){

        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productRepository.findAll();

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with Id: "+ productId));
        return ResponseEntity.ok(product);
    }
}

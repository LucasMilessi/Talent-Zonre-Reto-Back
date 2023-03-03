package com.sofka.reto.service;

import com.sofka.reto.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ResponseEntity<Product> addProduct(Product product);

    ResponseEntity<List<Product>> productList();

    Optional<Product> productById(Long id);

    ResponseEntity<Product> productUpdate(Long id, Product product);

    ResponseEntity<String> productDelete(Long id);
}

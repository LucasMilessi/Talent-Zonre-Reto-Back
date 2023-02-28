package com.sofka.reto.service;

import com.sofka.reto.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Product> addProduct(String name, int quantity);

    ResponseEntity<List<Product>> productList();

    ResponseEntity<Product> productUpdate(Product product);

    ResponseEntity<String> productDelete(Long id);
}

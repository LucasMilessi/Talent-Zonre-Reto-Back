package com.sofka.reto.controller;

import com.sofka.reto.model.Product;
import com.sofka.reto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> productList(){

        return productService.productList();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Product> productUpdate(@PathVariable("id") Long id, @RequestBody Product product){

        return productService.productUpdate(id, product);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> productDelete(@PathVariable("id") Long id){

        return productService.productDelete(id);
    }

}

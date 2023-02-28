package com.sofka.reto.controller;

import com.sofka.reto.model.Product;
import com.sofka.reto.service.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String message(){
        return "Hola";
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestParam String name, @RequestParam int quantity){

        return productService.addProduct(name, quantity);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> productList(){

        return productService.productList();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Product> productUpdate(@PathVariable("id") Long id, @RequestParam String name,
                                  @RequestParam Integer quantity, @RequestParam boolean enable,
                                  @RequestParam Integer min, @RequestParam Integer max){

        Product product;

        try{
        product = Product.builder()
                .id(id)
                .name(name)
                .inInventory(quantity)
                .enable(enable)
                .min(min)
                .max(max)
                .build();

        }catch (Exception e){
            throw new RuntimeException("Algo salio mal. "+e);
        }
        return productService.productUpdate(product);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> productDelete(@PathVariable("id") Long id){

        return productService.productDelete(id);
    }

}

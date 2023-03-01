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

    @PostMapping(path = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> addProduct(@RequestBody String name, @RequestBody Integer quantity){

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

        Product product = new Product();

        try{

            product.setId(id);
            product.setName(name);
            product.setInInventory(quantity);
            product.setEnable(enable);
            product.setMin(min);
            product.setMax(max);

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

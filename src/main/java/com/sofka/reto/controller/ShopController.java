package com.sofka.reto.controller;

import com.sofka.reto.model.Shop;
import com.sofka.reto.model.ProductList;
import com.sofka.reto.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(value = "/get")
    private ResponseEntity<List<Shop>> getBuy(){
        return shopService.shopList();
    }

    @PostMapping(value = "/buys")
    public ResponseEntity<Shop> addBuy(@RequestBody String name, @RequestBody String idType, @RequestBody String clientName,
                                       @RequestBody List<ProductList> products){

        return shopService.addBuy(name, idType, clientName, products);
    }

}

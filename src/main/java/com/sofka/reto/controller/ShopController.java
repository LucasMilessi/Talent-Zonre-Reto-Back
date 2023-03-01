package com.sofka.reto.controller;

import com.sofka.reto.model.Shop;
import com.sofka.reto.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(value = "/get")
    private ResponseEntity<List<Shop>> getBuy(){
        return shopService.shopList();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Shop> addBuy(@RequestBody Shop shop){

            return shopService.addBuy(shop);
    }

}

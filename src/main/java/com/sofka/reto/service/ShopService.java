package com.sofka.reto.service;

import com.sofka.reto.model.Shop;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShopService {

    ResponseEntity<Shop> addBuy(Shop shop);

    ResponseEntity<List<Shop>> shopList();
}

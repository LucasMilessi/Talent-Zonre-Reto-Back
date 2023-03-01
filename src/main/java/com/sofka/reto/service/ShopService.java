package com.sofka.reto.service;

import com.sofka.reto.model.ProductList;
import com.sofka.reto.model.Shop;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShopService {

    ResponseEntity<Shop> addBuy(String name, String idType, String clientName, List<ProductList> products);

    ResponseEntity<List<Shop>> shopList();
}

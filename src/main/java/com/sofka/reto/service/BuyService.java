package com.sofka.reto.service;

import com.sofka.reto.model.Shop;
import com.sofka.reto.model.RequestProduct;

import java.util.List;

public interface BuyService {

    List<Shop> getBuy();

    Shop addBuy(String name, String idType, String clientName, List<RequestProduct> products);
}

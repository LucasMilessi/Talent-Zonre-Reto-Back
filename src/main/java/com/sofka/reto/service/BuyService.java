package com.sofka.reto.service;

import com.sofka.reto.model.Buy;
import com.sofka.reto.model.RequestProduct;

import java.util.List;

public interface BuyService {

    List<Buy> getBuy();

    Buy addBuy(String name, String idType, String clientName, List<RequestProduct> products);
}

package com.sofka.reto.service.impl;

import com.sofka.reto.model.Shop;
import com.sofka.reto.model.RequestProduct;
import com.sofka.reto.repository.BuyRepository;
import com.sofka.reto.repository.ProductRepository;
import com.sofka.reto.service.BuyService;
import com.sofka.reto.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public List<Shop> getBuy(){
        return buyRepository.findAll();
    }

    @Override
    public Shop addBuy(String name, String idType, String clientName, List<RequestProduct> products){

        Shop shop = new Shop(name, idType, clientName);

        try {
            for(RequestProduct product : products){
                productUtil.calculateStock(product.getQuantity(), product.getIdProduct());
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

        return buyRepository.save(shop);
    }

}

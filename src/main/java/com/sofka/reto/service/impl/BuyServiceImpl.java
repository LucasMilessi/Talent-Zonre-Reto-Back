package com.sofka.reto.service.impl;

import com.sofka.reto.model.Buy;
import com.sofka.reto.model.RequestProduct;
import com.sofka.reto.repository.BuyRepository;
import com.sofka.reto.repository.ProductRepository;
import com.sofka.reto.service.BuyService;
import com.sofka.reto.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<Buy> getBuy(){
        return buyRepository.findAll();
    }

    @Override
    public Buy addBuy(String name, String idType, String clientName, List<RequestProduct> products){

        Buy buy = new Buy(name, idType, clientName);

        try {
            for(RequestProduct product : products){
                productUtil.calculateStock(product.getQuantity(), product.getIdProduct());
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

        return buyRepository.save(buy);
    }

}

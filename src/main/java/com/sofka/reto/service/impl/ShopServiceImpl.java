package com.sofka.reto.service.impl;

import com.sofka.reto.model.Shop;
import com.sofka.reto.model.ProductList;
import com.sofka.reto.repository.ShopRepository;
import com.sofka.reto.repository.ProductRepository;
import com.sofka.reto.service.ShopService;
import com.sofka.reto.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ResponseEntity<Shop> addBuy(String name, String idType, String clientName, List<ProductList> products){

        Shop shop = new Shop();

        try {
            List<ProductList> productLists = new ArrayList<>();
            shop.setName(name);
            shop.setType(idType);
            shop.setClientName(clientName);

            for(ProductList product : products){
                productUtil.calculateStock(product.getQuantity(), product.getIdProduct());
                productLists.add(product);
            }
            shop.setProductList(productLists);
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(shopRepository.save(shop), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Shop>> shopList(){

        return new ResponseEntity<>(shopRepository.findAll(), HttpStatus.OK);
    }

}

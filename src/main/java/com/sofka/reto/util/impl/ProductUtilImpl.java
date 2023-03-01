package com.sofka.reto.util.impl;

import com.sofka.reto.model.Product;
import com.sofka.reto.repository.ProductRepository;
import com.sofka.reto.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUtilImpl implements ProductUtil {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void calculateStock(Integer quantity, Long id) {

        Product product = productRepository.getById(id);

        try {
            if ((product.getMin() < quantity && product.getMax() > quantity) && (product.getInInventory() > quantity)) {
                product.setInInventory(product.getInInventory() - quantity);
                productRepository.save(product);
            }else{
                throw new Exception("LA CANTIDAD A INGRESAR NO SE ADMITE.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public boolean validateNull(Product product){

        if(product.getName().isEmpty() || (product.getInInventory() == null)
                || (product.getMin() == null) || (product.getMax() == null)){
            throw new RuntimeException("Hay campos vacios. Por favos intente nuevamente.");
        }

        return true;
    }
}

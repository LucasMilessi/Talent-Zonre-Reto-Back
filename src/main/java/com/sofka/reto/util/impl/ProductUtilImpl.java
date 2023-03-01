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
            if (product.getMin() < quantity || product.getMax() > quantity) {
                product.setInInventory(quantity - product.getInInventory());
                productRepository.save(product);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("LA CANTIDAD A INGRESAR NO SE ADMITE. "+ e);
        }
    }

    @Override
    public boolean validateNull(Product product){

        Boolean enable = product.isEnable();

        if((product.getId() == null) || product.getName().isEmpty() || (product.getInInventory() == null)
                || (enable == null) || (product.getMin() == null) || (product.getMax() == null)){
            throw new RuntimeException("Hay campos vacios. Por favos intente nuevamente.");
        }

        return true;
    }
}

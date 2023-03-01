package com.sofka.reto.util;

import com.sofka.reto.model.Product;

public interface ProductUtil {

    void calculateStock(Integer quantity, Long id);

    boolean validateNull(Product product);
}

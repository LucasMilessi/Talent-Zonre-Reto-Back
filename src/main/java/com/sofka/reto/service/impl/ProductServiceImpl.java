package com.sofka.reto.service.impl;

import com.sofka.reto.model.Product;
import com.sofka.reto.repository.ProductRepository;
import com.sofka.reto.service.ProductService;
import com.sofka.reto.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ResponseEntity<Product> addProduct(String name, int quantity){

        Product productResponse = new Product();

        try {
            productResponse.setName(name);
            productResponse.setInInventory(quantity);

        }catch (Exception e){
            throw new RuntimeException("Algo salio mal. "+e);
        }

        return new ResponseEntity<>(productRepository.save(productResponse), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Product>> productList(){

        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> productUpdate(Product product){

        Product productResponse = new Product();

        try {

            if(productUtil.validateNull(product)){
                productResponse = productRepository.getById(product.getId());

                productResponse.setName(product.getName());
                productResponse.setInInventory(product.getInInventory());
                productResponse.setEnable(product.isEnable());
                productResponse.setMin(product.getMin());
                productResponse.setMax(product.getMax());
            }

        }catch (Exception e){
            throw new RuntimeException("No se pudo actualizar el Producto. "+e);
        }

        return new ResponseEntity<>(productRepository.save(productResponse), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> productDelete(Long id){

        try {
            productRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<>("No se pudo borrar. "+e, HttpStatus.EXPECTATION_FAILED);
        }
    }
}

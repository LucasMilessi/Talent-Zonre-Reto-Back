package com.sofka.reto.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductList {

    @Id
    private Long id;

    private Long idProduct;

    private Integer quantity;

    public ProductList() {
    }

    public ProductList(Long idProduct, Integer quantity) {
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

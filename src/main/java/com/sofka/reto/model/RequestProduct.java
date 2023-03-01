package com.sofka.reto.model;

public class RequestProduct {

    private Long idProduct;

    private Integer quantity;

    public RequestProduct() {
    }

    public RequestProduct(Long idProduct, Integer quantity) {
        this.idProduct = idProduct;
        this.quantity = quantity;
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

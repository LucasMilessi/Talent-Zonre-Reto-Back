package com.sofka.reto.model;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buyId;

    @Column
    private String name;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String type;

    @Column
    private String clientName;

    @Column
    @ElementCollection(targetClass=ProductList.class)
    private List<ProductList> productList;

    public Shop() {
    }

    public Shop(String name, String type, String clientName, List<ProductList> productList) {
        this.name = name;
        this.dateTime = LocalDateTime.now();
        this.type = type;
        this.clientName = clientName;
        this.productList = productList;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<ProductList> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductList> productList) {
        this.productList = productList;
    }
}

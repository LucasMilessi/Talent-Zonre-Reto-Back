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
    private LocalDateTime dateTime;

    @Column
    private String type;

    @Column
    private String clientName;

    @Column
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyId")
    private List<ShopList> shopList;

    public Shop() {
    }

    public Shop(String type, String clientName, List<ShopList> shopList) {
        this.type = type;
        this.clientName = clientName;
        this.shopList = shopList;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
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

    public List<ShopList> getProductList(){
        return shopList;
    }

    public void setProductList(List<ShopList> shopList) {
        this.shopList = shopList;
    }
}

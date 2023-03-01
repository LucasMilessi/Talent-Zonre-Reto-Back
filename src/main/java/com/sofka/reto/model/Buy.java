package com.sofka.reto.model;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "buyout")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buyId;

    @Column
    private String name;

    @Column
    private LocalDateTime currentDate;

    @Column
    private String type;

    @Column
    private String clientName;

    public Buy() {
    }

    public Buy(String name, String type, String clientName) {
        this.name = name;
        this.currentDate = LocalDateTime.now();
        this.type = type;
        this.clientName = clientName;
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

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDateTime currentDate) {
        this.currentDate = currentDate;
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
}

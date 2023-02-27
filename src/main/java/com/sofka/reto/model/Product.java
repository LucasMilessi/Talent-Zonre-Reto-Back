package com.sofka.reto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 25)
    private String name;

    @Column(length = 25)
    private int inInventory;

    @Column(length = 25)
    private boolean enable;

    @Column(length = 25)
    private int min;

    @Column(length = 25, nullable = false)
    private int max;

}

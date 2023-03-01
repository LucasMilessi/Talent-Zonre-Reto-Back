package com.sofka.reto.repository;

import com.sofka.reto.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Shop, Long> {
}

package com.sofka.reto.controller;

import com.sofka.reto.model.Buy;
import com.sofka.reto.model.RequestProduct;
import com.sofka.reto.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @GetMapping(value = "/get")
    private List<Buy> getBuy(){
        return buyService.getBuy();
    }

    @PostMapping(value = "/buys")
    private Buy addBuy(@RequestParam String name, @RequestParam String idType, @RequestParam String clientName,
                       @RequestParam List<RequestProduct> products){

        return buyService.addBuy(name, idType, clientName, products);
    }

}

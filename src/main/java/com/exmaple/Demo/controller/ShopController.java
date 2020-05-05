package com.exmaple.Demo.controller;

import com.exmaple.Demo.service.ShopServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:9001","http://localhost:9000"})
public class

ShopController {
    @Autowired
    private ShopServiceImpl shopService;
    @GetMapping("/getAllShop")
    public String getAllShop() throws JsonProcessingException {
        return Jackson.classtoJson(shopService. selectAllShop());
    }

}

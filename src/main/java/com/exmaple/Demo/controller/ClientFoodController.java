package com.exmaple.Demo.controller;

import com.exmaple.Demo.service.FoodServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:9000")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class ClientFoodController {
    @Autowired
    FoodServiceImpl foodService;

    @GetMapping("/selectAllFood")
    public String  selectAllFood() throws JsonProcessingException {
        System.out.println("111111");
        return Jackson.classtoJson(foodService.selectAllFood());
    }
    @GetMapping("/showTheShopFood")
    public String  showTheShopFood(String shopname) throws JsonProcessingException {
        System.out.println("111111");
        return Jackson.classtoJson(foodService.showTheShopFood(shopname));
    }
}

package com.exmaple.Demo.controller;

import com.exmaple.Demo.service.ClientFoodService;
import com.exmaple.Demo.service.ClientFoodServiceImpl;

import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:9000")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class ClientFoodController {
    @Autowired
    private ClientFoodServiceImpl clientFoodService;

    @GetMapping("/selectAllFood") //需要权限
    public String  selectAllFood() throws JsonProcessingException {
        System.out.println("111111");
        return Jackson.classtoJson(clientFoodService.selectAllFood());
    }
    @GetMapping("/selectAllFoodClient") // 不需要权限
    public String  selectAllFoodClient() throws JsonProcessingException {
        System.out.println("111111");
        return Jackson.classtoJson(clientFoodService.selectAllFood());
    }
    @GetMapping("/showTheShopFood")
    public String  showTheShopFood(String shopname) throws JsonProcessingException {
        System.out.println("111111");
        return Jackson.classtoJson(clientFoodService.showTheShopFood(shopname));
    }
    @PostMapping("/selectTagFood")
    public String selectTagFood(@RequestBody List<List<Integer>> list) throws JsonProcessingException {
        System.out.println("||||||||||||||||||||||||||");
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < list.get(i).size(); i1++) {
                System.out.println(list.get(i).get(i1));
            }
            System.out.println("/////////");
        }

        return Jackson.classtoJson(clientFoodService.selectTagFood(list));
    }
}

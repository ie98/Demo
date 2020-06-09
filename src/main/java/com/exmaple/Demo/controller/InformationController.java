package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.Food;
import com.exmaple.Demo.model.Shop;
import com.exmaple.Demo.model.User;
import com.exmaple.Demo.service.InformationServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:9001")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class InformationController {
    @Autowired
    private InformationServiceImpl informationService;
    @PostMapping("/selectAllUser")
    public String selectAllUser(@RequestBody Query query) throws JsonProcessingException {
        System.out.println(query.getPageSize()+"_"+query.getPageNum());
        return Jackson.classtoJson( informationService.selectAllUser(query));
    }
    @PostMapping("/selectAllAdmin")
    public String selectAllAdmin(@RequestBody Query query) throws JsonProcessingException {
        System.out.println(query.getPageSize()+"_"+query.getPageNum());
        return Jackson.classtoJson(informationService.selectAllAdmin(query));
    }
    @PostMapping("/selectAllRecord")
    public String selectAllRecord(@RequestBody Query query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAllRecord(query));
    }
    @PostMapping("/selectAllShop")
    public String selectAllShop(@RequestBody Query query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAllShop(query));
    }
    @PostMapping("/selectAllFood")
    public String selectAllFood(@RequestBody Query query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAllFood(query));
    }

    @PutMapping("/updateUserState")
    public String updateUserState(@RequestBody User user) throws JsonProcessingException {
        System.out.println(user.toString());
        return Jackson.classtoJson(informationService.updateUserState(user)==true?new Meta("SUCCESS"):new Meta("ERROR"));
    }
    @GetMapping("/selectUser")
    public String selectUser(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectUser(query));
    }
    @PutMapping("/updateAdminState")
    public String updateAdminState(@RequestBody Admin admin) throws JsonProcessingException {
        System.out.println(admin.toString());
        return Jackson.classtoJson(informationService.updateAdminState(admin)==true?new Meta("SUCCESS"):new Meta("ERROR"));
    }
    @GetMapping("/selectAdmin")
    public String selectAdmin(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAdmin(query));
    }
    @GetMapping("/selectRecord")
    public String selectRecord(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectRecord(query));
    }
    @PutMapping("/updateShopState")
    public String updateShopState(@RequestBody Shop shop ) throws JsonProcessingException {

        return Jackson.classtoJson(informationService.updateShopState(shop)==true?new Meta("SUCCESS"):new Meta("ERROR"));
    }
    @PutMapping("/updateFoodState")
    public String updateFoodState(@RequestBody Food food ) throws JsonProcessingException {

        return Jackson.classtoJson(informationService.updateFoodState(food)==true?new Meta("SUCCESS"):new Meta("ERROR"));
    }
    @GetMapping("/selectFood")
    public String selectFood(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectFood(query));
    }
    @GetMapping("/selectShop")
    public String selectShop(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectShop(query));
    }
    @PostMapping("selectAllFoodNotQuery")
    public String selectAllFoodNotQuery() throws JsonProcessingException {
       return Jackson.classtoJson(informationService.selectAllFoodNotQuery()) ;
    }
    @PostMapping("selectAllFoodRecord/{query}")
    public String selectAllFoodRecord(@PathVariable("query") String shopname,@RequestBody Query query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAllFoodRecord(query,shopname)) ;
    }




}

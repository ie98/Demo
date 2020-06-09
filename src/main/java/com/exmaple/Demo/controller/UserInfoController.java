package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.PasswordAndId;
import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.mapper.FoodRecordMapper;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.service.UserInfoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:9000")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl userInfoService;
    @PostMapping("/updatePassword")
    public String updatePassword( @RequestBody PasswordAndId passwordAndId) throws JsonProcessingException {
        System.out.println("123456789");
        System.out.println(passwordAndId.getPassword());
        System.out.println(passwordAndId.getId());
        return new ObjectMapper().writeValueAsString(userInfoService.updatePassword(passwordAndId.getPassword(),passwordAndId.getId()));

    }
    @PostMapping("/selectFoodRecord/{id}")
    public String selectFoodRecord( @PathVariable("id") int id ,@RequestBody Query query) throws JsonProcessingException {
        System.out.println("123456789");
        System.out.println(query.getPageSize());
        System.out.println(query.getPageNum());
        return new ObjectMapper().writeValueAsString(userInfoService.selectFoodRecordById(query,id));

    }
    @PostMapping("/userInfo/{id}")
    public String userInfo( @PathVariable("id") int id ) throws JsonProcessingException {
        System.out.println("123456789");
        return new ObjectMapper().writeValueAsString(userInfoService.userInfoById(id));

    }
    @PostMapping("/selectSitRecordInfo/{username}")
    public String selectSitRecordInfo( @PathVariable("username") String name , @RequestBody Query query ) throws JsonProcessingException {
        System.out.println("123456789");
        return new ObjectMapper().writeValueAsString(userInfoService.sitRecordInfoById(query,name));

    }

}

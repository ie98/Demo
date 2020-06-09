package com.exmaple.Demo.controller;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.RegisterUser;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.service.RegisterServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = {"http://localhost:9000","http://localhost:9001"})

//@CrossOrigin("http://30j75285x8.qicp.vip")
public class RegisterController {
        @Autowired
        private RegisterServiceImpl registerService;
        @PostMapping("/register")
    public  String register(@RequestBody RegisterUser user) throws JsonProcessingException {
            System.out.println("reigister");
            System.out.println(user.getUsername());
            Boolean bool = registerService.insertUser(user);
            if (bool){
                return Jackson.classtoJson(new Meta("SUCCESS"));

            }else{
                return Jackson.classtoJson(new Meta("USER_HAS_EXISTED"));

            }
        }
}

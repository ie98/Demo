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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("http://localhost:9000")
public class RegisterController {
        @Autowired
        private RegisterServiceImpl registerService;
        @PostMapping("/register")
        @ResponseBody
    public  String register(@RequestBody RegisterUser user) throws JsonProcessingException {
            System.out.println("reigister");
            System.out.println(user.getUsername());
            Boolean bool = registerService.insertUser(user);
            if (bool){
                return Jackson.classtoJson(new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")));

            }else{
                return Jackson.classtoJson(new Meta(ResultCode.getMessage("USER_HAS_EXISTED"),ResultCode.getCode("USER_HAS_EXISTED")));

            }
        }
}

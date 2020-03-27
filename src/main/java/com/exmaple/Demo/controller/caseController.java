package com.exmaple.Demo.controller;

import com.exmaple.Demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ct")
@CrossOrigin("http://localhost:9000")
public class caseController {

    @GetMapping("/first")
    @ResponseBody
    public  String first() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setUsername("libai");
        user.setId(123);
        user.setAccountid("456");
        String str = mapper.writeValueAsString(user);
        System.out.println(str);
        return str;
    }

}

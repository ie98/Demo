package com.exmaple.Demo.controller;

import com.exmaple.Demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ct")
//@CrossOrigin("http://localhost:9000")
public class caseController {

    @GetMapping("/first")
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

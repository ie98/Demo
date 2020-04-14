package com.exmaple.Demo.controller;

import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.User;
import com.exmaple.Demo.service.LoginService;
import com.exmaple.Demo.service.LoginServiceImpl;
import com.exmaple.Demo.service.SitSelectServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@CrossOrigin("http://localhost:9000")

//@CrossOrigin("http://30j75285x8.qicp.vip")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImple;
    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, @RequestBody  User user1 ) throws JsonProcessingException {
        System.out.println("123456789");
        return new ObjectMapper().writeValueAsString(loginServiceImple.loginCheck(user1));

    }

}

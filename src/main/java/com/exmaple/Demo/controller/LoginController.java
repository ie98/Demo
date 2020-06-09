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
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
//@CrossOrigin("http://localhost:9000")
//
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImple;
    @GetMapping("/login")
    public String login(String username,String password,HttpSession session) throws JsonProcessingException {
        System.out.println("tologin");
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        if (loginServiceImple.loginCheck(user1).getMeta().getStatus() == 0){
            System.out.println("tosession");
            session.setAttribute("user",user1);
            System.out.println("tosession");
        }
        return new ObjectMapper().writeValueAsString(loginServiceImple.loginCheck(user1));//jackson将对象转为json数据
    }



}

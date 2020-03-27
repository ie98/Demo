package com.exmaple.Demo.controller;

import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.User;
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
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/login")
    @ResponseBody
    public String index(HttpServletRequest request, @RequestBody  User user1 ) throws JsonProcessingException {
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if ("token".equals(cookie.getName())){
//                 User user = userMapper.findByToken(cookie.getValue());
//                 if (user != null){
//                     System.out.println(user.getName());
//                     request.getSession().setAttribute("user" , user);
//                     break;
//                 }
//            }
//        }

        System.out.println(user1.getPassword());
        System.out.println(user1.getUsername());
        User user = new User();
        user.setUsername("libai");
        user.setId(741);
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);
        return str ;

    }
}

package com.exmaple.Demo.controller;

import com.exmaple.Demo.mapper.UserMapper;
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
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SitSelectServiceImpl sitSelectServiceImpl;
    @Autowired
    private LoginServiceImpl loginServiceImple;
    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, @RequestBody  User user1 ) throws JsonProcessingException {
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
//        System.out.println(bool);
//        User user = new User();
//        user.setUsername("libai");
//        user.setId(741);
//        ObjectMapper mapper = new ObjectMapper();
//        String str = mapper.writeValueAsString(user);
//        sitSelectServiceImpl.selectAllChair();
//        sitSelectServiceImpl.selectOne();
     //   sitSelectServiceImpl.selectAllTable();
        return new ObjectMapper().writeValueAsString(loginServiceImple.loginCheck(user1));

    }
}

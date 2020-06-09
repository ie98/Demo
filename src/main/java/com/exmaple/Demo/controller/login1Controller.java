package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.util.Jackson;
import com.exmaple.Demo.util.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:9000")
public class login1Controller {
    @GetMapping("/error")
    public String error() throws JsonProcessingException {
        System.out.println("45645646545646545646");
        return Jackson.classtoJson(new Meta("MEIYOUGAIQUANXIAN"));
    }
    @GetMapping("/toLogin")
    public String toLogin() throws JsonProcessingException {
        System.out.println("45645646545646545646");
        return Jackson.classtoJson(new Meta("TO_LOGIN"));
    }
//    @RequestMapping("/login1")
////    @ResponseBody
//    public String tologin1(Model model){
//        System.out.println("login1");
//        return "login";
//    }
//    @RequestMapping("/toIndex")
////    @ResponseBody
//    public String toIndex(Model model){
//        System.out.println("index");
//        return "index";
//    }
//    @RequestMapping("/aslogin")
////    @ResponseBody
//    public String aslogin(String  username , String password, Model model){
//        System.out.println("aslogin");
//        System.out.println(username);
//        System.out.println(password);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username , password);
//        try {
//            subject.login(token);
//            return "index";
//        }catch (UnknownAccountException e){
//            model.addAttribute("msg","用户名错误");
//            return "login";
//        }catch (IncorrectCredentialsException e){
//
//            model.addAttribute("msg","密码错误");
//            return "login";
//        }
//
//    }
//    @RequestMapping("/user/add")
////    @ResponseBody
//    public String toAdd(Model model){
//        System.out.println("add");
//        return "user/add";
//    }
//    @RequestMapping("/user/update")
////    @ResponseBody
//    public String toUpdate(Model model){
//        System.out.println("update");
//        return "user/update";
//    }

}

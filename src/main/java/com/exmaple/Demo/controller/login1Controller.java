package com.exmaple.Demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("http://localhost:9000")
public class login1Controller {
//    @RequestMapping("/naouth")
////    @ResponseBody
//    public String naouth(Model model){
//        System.out.println("naouth");
//        return "login";
//    }
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

package com.exmaple.Demo.controller;

import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.service.AdminManageService;
import com.exmaple.Demo.service.AdminManageServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.exmaple.Demo.model.User;
@Controller
@CrossOrigin("http://localhost:9001")
public class AdminManageController {
@Autowired
    private AdminManageServiceImpl adminManageService;
/*---------------------------USER-----------------*/
    @ResponseBody
    @DeleteMapping("/user/{userid}")
    public String deleteUser(@PathVariable("userid") int id) throws JsonProcessingException {
        System.out.println("1111111111");      
            return Jackson.classtoJson(adminManageService.deleteUser(id));
    }

    @PostMapping("/editUser")
    @ResponseBody
    public String editUser(@RequestBody User user ) throws JsonProcessingException {
        System.out.println(user.toString());
        return Jackson.classtoJson(adminManageService.editUser(user));
    }

    /*-------------------------Admin------------------------*/
    @ResponseBody
    @DeleteMapping("/admin/{adminid}")
    public String deleteAdmin(@PathVariable("adminid") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteAdmin(id));
    }

    @PostMapping("/editAdmin")
    @ResponseBody
    public String editAdmin(@RequestBody Admin admin ) throws JsonProcessingException {
        System.out.println(admin.toString());
        return Jackson.classtoJson(adminManageService.editAdmin(admin));
    }
}

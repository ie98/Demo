package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.RemarksAndId;
import com.exmaple.Demo.model.*;
import com.exmaple.Demo.service.AdminManageService;
import com.exmaple.Demo.service.AdminManageServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@CrossOrigin("http://localhost:9001")
public class AdminManageController {
@Autowired
    private AdminManageServiceImpl adminManageService;
/*---------------------------USER-----------------*/
    @DeleteMapping("/user/{userid}")
    public String deleteUser(@PathVariable("userid") int id) throws JsonProcessingException {
        System.out.println("1111111111");      
            return Jackson.classtoJson(adminManageService.deleteUser(id));
    }

    @PostMapping("/editUser")
    public String editUser(@RequestBody User user ) throws JsonProcessingException {
        System.out.println(user.toString());
        return Jackson.classtoJson(adminManageService.editUser(user));
    }

    /*-------------------------Admin------------------------*/
    @DeleteMapping("/admin/{adminid}")
    public String deleteAdmin(@PathVariable("adminid") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteAdmin(id));
    }

    @PostMapping("/editAdmin")
    public String editAdmin(@RequestBody Admin admin ) throws JsonProcessingException {
        System.out.println(admin.toString());
        return Jackson.classtoJson(adminManageService.editAdmin(admin));
    }
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestBody Admin admin) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addAdmin(admin));
    }
    //=========================record=================
    @PostMapping("/editRemarks")
    public String editRemarks(@RequestBody RemarksAndId remarks) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editRemarks(remarks));
    }
    @DeleteMapping("/record/{id}")
    public String deleteRecord(@PathVariable("id") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteRecord(id));
    }
    //=========================shop============
    @PostMapping("/addShop")
    public String addShop(@RequestBody Shop shop) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addShop(shop));
    }
    @PostMapping("/editShop")
    public String editShop(@RequestBody Shop shop) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editShop(shop));
    }
    @DeleteMapping("/shop/{id}")
    public String deleteShop(@PathVariable("id") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteShop(id));
    }

    //=========================food=================
    @PostMapping("/addFood")
    public String addShop(@RequestBody Food food) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addFood(food));
    }
    @PostMapping("/editFood")
    public String editFood(@RequestBody Food food) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editFood(food));
    }
    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable("id") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteFood(id));
    }
    //上传图片
    @RequestMapping("/uploadImg")
    public void  uploadImg(@RequestParam(value = "file") MultipartFile file , @RequestParam("foodname") String foodname) throws IOException {
        adminManageService.uploadImg(file , foodname);
        }

    //========================Role=============
    @DeleteMapping("/role/{id}")
    public String deleteRole(@PathVariable("id") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteRole(id));
    }
    @PostMapping("/editRole")
    public String editRole(@RequestBody Role role) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editRole(role));
    }
    @PostMapping("/addRole")
    public String addRole(@RequestBody Role role ) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addRole(role));
    }


}

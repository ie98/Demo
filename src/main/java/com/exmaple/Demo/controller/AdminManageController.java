package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.RemarksAndId;
import com.exmaple.Demo.mapper.FoodRecordMapper;
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
//@CrossOrigin(origins = {"http://localhost:9000","http://localhost:9001"})
public class AdminManageController {
    @Autowired
    private AdminManageServiceImpl adminManageService;

    /*---------------------------USER-----------------*/
    /**
     * @Description deleteUser
     * @Author 411头目
     * @Date 2020/5/25 21:12
     * Param [id]
     * Return java.lang.String
     **/
    @DeleteMapping("/user/{userid}")
    public String deleteUser(@PathVariable("userid") int id) throws JsonProcessingException {
        System.out.println("1111111111");
        return Jackson.classtoJson(adminManageService.deleteUser(id));
    }

    /**
     * @Description editUser
     * @Author 411头目
     * @Date 2020/5/25 21:12
     * Param [user]
     * Return java.lang.String
     **/
    @PostMapping("/editUser")
    public String editUser(@RequestBody User user) throws JsonProcessingException {
        System.out.println(user.toString());
        return Jackson.classtoJson(adminManageService.editUser(user));
    }

    /*-------------------------Admin------------------------*/

    /**
     * @Description deleteAdmin
     * @Author 411头目
     * @Date 2020/5/25 21:12
     * Param [id]
     * Return java.lang.String
     **/
    @DeleteMapping("/admin/{adminid}")
    public String deleteAdmin(@PathVariable("adminid") int id) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.deleteAdmin(id));
    }

    /**
     * @Description editAdmin
     * @Author 411头目
     * @Date 2020/5/25 21:12
     * Param [admin]
     * Return java.lang.String
     **/
    @PostMapping("/editAdmin")
    public String editAdmin(@RequestBody Admin admin) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editAdmin(admin));
    }

    /**
     * @Description addAdmin
     * @Author 411头目
     * @Date 2020/5/25 21:13
     * Param [admin]
     * Return java.lang.String
     **/
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestBody Admin admin) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addAdmin(admin));
    }

    //=========================record=================

    /**
     * @Description editRemarks
     * @Author 411头目
     * @Date 2020/5/25 21:13
     * Param [remarks]
     * Return java.lang.String
     **/
    @PostMapping("/editRemarks")
    public String editRemarks(@RequestBody RemarksAndId remarks) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editRemarks(remarks));
    }

    /**
     * @Description deleteRecord
     * @Author 411头目
     * @Date 2020/5/25 21:13
     * Param [id]
     * Return java.lang.String
     **/
    @DeleteMapping("/record/{id}")
    public String deleteRecord(@PathVariable("id") int id) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.deleteRecord(id));
    }

    //=========================shop============

    /**
     * @Description addShop
     * @Author 411头目
     * @Date 2020/5/25 21:13
     * Param [shop]
     * Return java.lang.String
     **/
    @PostMapping("/addShop")
    public String addShop(@RequestBody Shop shop) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addShop(shop));
    }

    /**
     * @Description editShop
     * @Author 411头目
     * @Date 2020/5/25 21:14
     * Param [shop]
     * Return java.lang.String
     **/
    @PostMapping("/editShop")
    public String editShop(@RequestBody Shop shop) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editShop(shop));
    }

    /**
     * @Description deleteShop
     * @Author 411头目
     * @Date 2020/5/25 21:14
     * Param [id]
     * Return java.lang.String
     **/
    @DeleteMapping("/shop/{id}")
    public String deleteShop(@PathVariable("id") int id) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.deleteShop(id));
    }

    //=========================food=================

    /**
     * @Description addShop
     * @Author 411头目
     * @Date 2020/5/25 21:15
     * Param [food]
     * Return java.lang.String
     **/
    @PostMapping("/addFood")
    public String addShop(@RequestBody Food food) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addFood(food));
    }

    /**
     * @Description editFood
     * @Author 411头目
     * @Date 2020/5/25 21:17
     * @Param [food]
     * @Return java.lang.String
     **/
    @PostMapping("/editFood")
    public String editFood(@RequestBody Food food) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editFood(food));
    }

    /**
     * @Description deleteFood
     * @Author 411头目
     * @Date 2020/5/25 21:17
     * @Param [id]
     * @Return java.lang.String
     **/
    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable("id") int id) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.deleteFood(id));
    }

    /**
     * @Description 上传图片
     * @Author 411头目
     * @Date 2020/5/25 21:16
     * Param [file, foodname, shopname]
     * Return void
     **/
    @RequestMapping("/uploadImg")
    public void uploadImg(@RequestParam(value = "file") MultipartFile file, @RequestParam("foodname") String foodname, @RequestParam("shopname") String shopname) throws IOException {
        adminManageService.uploadImg(file, foodname, shopname);
    }

    //========================Role=============

    /**
     * @Description deleteRole
     * @Author 411头目
     * @Date 2020/5/25 21:17
     * @Param [id]
     * @Return java.lang.String
     **/
    @DeleteMapping("/role/{id}")
    public String deleteRole(@PathVariable("id") int id) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.deleteRole(id));
    }

    /**
     * @Description editRole
     * @Author 411头目
     * @Date 2020/5/25 21:17
     * @Param [role]
     * @Return java.lang.String
     **/
    @PostMapping("/editRole")
    public String editRole(@RequestBody Role role) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.editRole(role));
    }

    /**
     * @Description addRole
     * @Author 411头目
     * @Date 2020/5/25 21:16
     * Param [role]
     * Return java.lang.String
     **/
    @PostMapping("/addRole")
    public String addRole(@RequestBody Role role) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.addRole(role));
    }


    //===========================FoodRecord

    /**
     * @Description disposeFoodRecord
     * @Author 411头目
     * @Date 2020/5/25 21:18
     * @Param [id, userid]
     * @Return java.lang.String
     **/
    @PostMapping("/disposeFoodRecord/{id}/{userid}")
    public String disposeFoodRecord(@PathVariable("id") int id, @PathVariable("userid") int userid) throws JsonProcessingException {
        return Jackson.classtoJson(adminManageService.disposeFoodRecord(id, userid));
    }

    /**
     * @Description confirmDisposeFoodRecord
     * @Author 411头目
     * @Date 2020/5/25 21:18
     * @Param [id]
     * @Return java.lang.String
     **/
    @PostMapping("/confirmDisposeFoodRecord/{id}")
    public String confirmDisposeFoodRecord(@PathVariable("id") String id) throws JsonProcessingException {
        int foodRecordId = Integer.parseInt(id);
        return Jackson.classtoJson(adminManageService.confirmDisposeFoodRecord(foodRecordId));
    }
}

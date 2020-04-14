package com.exmaple.Demo.controller;
import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.User;
import com.exmaple.Demo.dto.SelectAllUser;
import com.exmaple.Demo.dto.UserQuery;
import com.exmaple.Demo.service.InformationService;
import com.exmaple.Demo.service.InformationServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("http://localhost:9001")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class InformationController {
    @Autowired
    private InformationServiceImpl informationService;
    @PostMapping("/selectAllUser")
    @ResponseBody
    public String selectAllUser(@RequestBody UserQuery userQuery) throws JsonProcessingException {
        System.out.println(userQuery.getPageSize()+"_"+userQuery.getPageNum());
        return Jackson.classtoJson( informationService.selectAllUser(userQuery));
    }
    @PostMapping("/selectAllAdmin")
    @ResponseBody
    public String selectAllAdmin() throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAllAdmin());
    }
    @PostMapping("/selectAllRecord")
    @ResponseBody
    public String selectAllRecord() throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAllRecord());
    }
    @PutMapping("/updateUserState")
    @ResponseBody
    public String updateUserState(@RequestBody User user) throws JsonProcessingException {
        System.out.println(user.toString());
        return Jackson.classtoJson(informationService.updateUserState(user)==true?new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")):new Meta(ResultCode.getMessage("ERROR"),ResultCode.getCode("ERROR")));
    }
    @GetMapping("/selectUser")
    @ResponseBody
    public String selectUser(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectUser(query));
    }
    @PutMapping("/updateAdminState")
    @ResponseBody
    public String updateAdminState(@RequestBody Admin admin) throws JsonProcessingException {
        System.out.println(admin.toString());
        return Jackson.classtoJson(informationService.updateAdminState(admin)==true?new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")):new Meta(ResultCode.getMessage("ERROR"),ResultCode.getCode("ERROR")));
    }
    @GetMapping("/selectAdmin")
    @ResponseBody
    public String selectAdmin(String query) throws JsonProcessingException {
        return Jackson.classtoJson(informationService.selectAdmin(query));
    }

}

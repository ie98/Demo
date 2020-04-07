package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.SelectAllUser;
import com.exmaple.Demo.service.InformationService;
import com.exmaple.Demo.service.InformationServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("http://localhost:9001")
public class InformationController {
    @Autowired
    private InformationServiceImpl informationService;
    @PostMapping("/selectAllUser")
    @ResponseBody
    public String selectAllUser() throws JsonProcessingException {
        SelectAllUser allUser = new SelectAllUser();
        allUser.setAllUser(informationService.selectAllUser());
        return Jackson.classtoJson(allUser);
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
}

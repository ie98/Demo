package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.ChairAbsC;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.service.AdminLoginServiceImpl;
import com.exmaple.Demo.service.ChairControllerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin()
public class ChairAbsController {  //座位绝对控制权接口
@Autowired
    private ChairControllerServiceImpl chairControllerService;
    @PostMapping("/chairAbsController")
    @ResponseBody
    public String chairAbsController(@RequestBody ChairAbsC chairAbsC) throws JsonProcessingException {
        return chairControllerService.ChairController(chairAbsC.getArr(),chairAbsC.getLocation()).toString();
    }

}

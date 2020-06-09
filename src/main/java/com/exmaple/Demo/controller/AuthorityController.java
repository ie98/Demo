package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.RII;
import com.exmaple.Demo.dto.UpdateAuthority;
import com.exmaple.Demo.service.AuthorityServiceImpl;
import com.exmaple.Demo.service.InformationServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:9001")
public class AuthorityController {
    @Autowired
    private AuthorityServiceImpl authorityService;
    @Autowired
    private InformationServiceImpl informationService;

    @GetMapping("/getAuthority")
    public String getAuthority(int id) throws JsonProcessingException {
        System.out.println(id);
        return Jackson.classtoJson(authorityService.getAuthorityList(id));
    }
    @PostMapping("/getAllAuthorityList")
    public String getAllAuthorityList(@RequestBody Query query) throws JsonProcessingException {
        System.out.println(query.getPageSize()+"_"+query.getPageNum());
        return Jackson.classtoJson(authorityService.getAllAuthorityList(query));
    }
//    @PostMapping("/getAllAuthorityList")
//    public String getAllAuthorityList() throws JsonProcessingException {
//        return Jackson.classtoJson(authorityService.getAllAuthorityList());
//    }
    @PostMapping("/selectAllRoleAndAuthority")
    public String selectAllRoleAndAuthority(@RequestBody Query query) throws JsonProcessingException {
        return Jackson.classtoJson(authorityService.selectAllRoleAndAuthority(query));
    }

    @PostMapping("/deleteAuthorityByid")
    public String deleteAuthorityByid(@RequestBody RII rii) throws JsonProcessingException {
        return Jackson.classtoJson(authorityService.deleteAuthorityByid(rii));
    }
    @PostMapping("/allAuthorityTree")
    public String allAuthorityTree() throws JsonProcessingException {
        return Jackson.classtoJson(authorityService.allAuthorityTree());
    }
    @PostMapping("/updateAuthority")
    public String updateAuthority(@RequestBody UpdateAuthority updateAuthority) throws JsonProcessingException {
        return Jackson.classtoJson(authorityService.updateAuthority(updateAuthority));
    }
    @GetMapping("/getAuthorityString")
    public String getAuthorityString(int id) throws JsonProcessingException {
        System.out.println(id);
        return Jackson.classtoJson(authorityService.getAuthorityString(id));
    }
    //=======================Role

}


package com.exmaple.Demo.controller;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.PeopleNumber;
import com.exmaple.Demo.dto.SelectConfirm;
import com.exmaple.Demo.dto.TablesAndMeta;
import com.exmaple.Demo.mapper.ChairMapper;
import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.service.SitSelectServiceImpl;
import com.exmaple.Demo.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.cj.xdevapi.SelectStatementImpl;
import org.apache.ibatis.annotations.Select;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
//@CrossOrigin("http://localhost:9000")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class SitSelectController {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    SitSelectServiceImpl sitSelectServiceImpl;

    @GetMapping("/inLeft")
    public String inLeft() throws JsonProcessingException {
        System.out.println("aaaa");
        List<DiningTable> list =  sitSelectServiceImpl.selectAllChair("diningtable_1");
        return Jackson.classtoJson(list);
    }
    @GetMapping("/inRight")
    public String inRight() throws JsonProcessingException {
        return Jackson.classtoJson(sitSelectServiceImpl.selectAllChair("diningtable_2"));
    }
    @PostMapping("/recommendSit")
    public String recommendSit(@RequestBody PeopleNumber peopleNumber) throws JsonProcessingException {
//        for (int i = 0; i < peopleNumber.getAllPeopleName().length; i++) {
//            System.out.println(peopleNumber.getAllPeopleName()[i].getName());
//        }
        if(sitSelectServiceImpl.tooMany(peopleNumber.getRegion(),peopleNumber.getPeopleNumber())){

            List<DiningTable> list = sitSelectServiceImpl.selectAllChair(("diningtable_1".equals(peopleNumber.getRegion())) ? "diningtable_1" : "diningtable_2");
            List<DiningTable> recommendSit = SelectChairUtil.adjust(list,new BFSchoice().BFS(list, peopleNumber.getPeopleNumber()));
            return    Jackson.classtoJson( new TablesAndMeta(recommendSit,new Meta("SUCCESS")));
        }else{
            return   Jackson.classtoJson( new TablesAndMeta(null,new Meta("PARAM_TO_MANY")));
        }
    }
    @PostMapping("/selectConfirm")
    public String selectConfirm(@RequestBody SelectConfirm selectConfirm) throws JsonProcessingException {

        Check check = new Check();
        System.out.println("selectConfirm"+selectConfirm.getToken());
        System.out.println("selectConfirm"+selectConfirm.getUserId());
//        if(check.tokenCheck(selectConfirm.getToken(),selectConfirm.getUserId()) == null)
//            return Jackson.classtoJson(new Meta(ResultCode.getMessage("TOKEN_LOSE"),ResultCode.getCode("TOKEN_LOSE")));
        if (sitSelectServiceImpl.selectConfirm(selectConfirm))
            return Jackson.classtoJson(new Meta("SUCCESS"));
            return Jackson.classtoJson(new Meta("RESULE_DATA_NONE"));
    }

}
//解决缓存穿透问题
//        if (null == chairs){
//        synchronized (this) {
//            chairs = (List<DiningTable>) redisTemplate.opsForValue().get("allTable");
//            if (null == chairs) {
//                chairs = sitSelectServiceImpl.selectAllChair("diningtable_1");
//                redisTemplate.opsForValue().set("allTable", chairs);
//            }
//        }
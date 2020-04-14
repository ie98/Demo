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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin("http://localhost:9000")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class SitSelectController {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    SitSelectServiceImpl sitSelectServiceImpl;

    @GetMapping("/inLeft")
    @ResponseBody
    public String inLeft() throws JsonProcessingException {
        System.out.println("aaaa");
        return Jackson.classtoJson(sitSelectServiceImpl.selectAllChair("diningtable_1"));
    }
    @GetMapping("/inRight")
    @ResponseBody
    public String inRight() throws JsonProcessingException {
        return Jackson.classtoJson(sitSelectServiceImpl.selectAllChair("diningtable_2"));
    }
    @PostMapping("/recommendSit")
    @ResponseBody
    public String recommendSit(@RequestBody PeopleNumber peopleNumber) throws JsonProcessingException {
        for (int i = 0; i < peopleNumber.getAllPeopleName().length; i++) {
            System.out.println(peopleNumber.getAllPeopleName()[i].getName());
        }
        return  sitSelectServiceImpl.tooMany(peopleNumber.getRegion(),peopleNumber.getPeopleNumber())?
            Jackson.classtoJson( new TablesAndMeta(SelectChairUtil.adjust(sitSelectServiceImpl.selectAllChair(("diningtable_1".equals(peopleNumber.getRegion())) ? "diningtable_1" : "diningtable_2"), new BFSchoice().BFS(sitSelectServiceImpl.selectAllChair(("diningtable_1".equals(peopleNumber.getRegion())) ? "diningtable_1" : "diningtable_2"), peopleNumber.getPeopleNumber())),
                    new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")))):
                Jackson.classtoJson( new TablesAndMeta(null,new Meta(ResultCode.getMessage("PARAM_TO_MANY"),ResultCode.getCode("PARAM_TO_MANY"))));
    }
    @PostMapping("/selectConfirm")
    @ResponseBody
    public String selectConfirm(@RequestBody SelectConfirm selectConfirm) throws JsonProcessingException {

        Check check = new Check();
        System.out.println("selectConfirm"+selectConfirm.getToken());
        System.out.println("selectConfirm"+selectConfirm.getUserId());
//        if(check.tokenCheck(selectConfirm.getToken(),selectConfirm.getUserId()) == null)
//            return Jackson.classtoJson(new Meta(ResultCode.getMessage("TOKEN_LOSE"),ResultCode.getCode("TOKEN_LOSE")));
        if (sitSelectServiceImpl.selectConfirm(selectConfirm))
            return Jackson.classtoJson(new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")));
            return Jackson.classtoJson(new Meta(ResultCode.getMessage("RESULE_DATA_NONE"),ResultCode.getCode("RESULE_DATA_NONE")));
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
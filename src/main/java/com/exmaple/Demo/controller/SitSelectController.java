package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.PeopleNumber;
import com.exmaple.Demo.mapper.ChairMapper;
import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;
import com.exmaple.Demo.service.SitSelectServiceImpl;
import com.exmaple.Demo.util.BFSchoice;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.cj.xdevapi.SelectStatementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:9000")
public class SitSelectController {

    @Autowired
    SitSelectServiceImpl sitSelectServiceImpl;
    @GetMapping("/inFirstFloor")
    @ResponseBody
    public String inFirstFloor() throws JsonProcessingException {
        return Jackson.classtoJson(sitSelectServiceImpl.selectAllChair("diningtable_1"));
    }
    @GetMapping("/inSecondFloor")
    @ResponseBody
    public String inSecondFloor() throws JsonProcessingException {
        return Jackson.classtoJson(sitSelectServiceImpl.selectAllChair("diningtable_2"));
    }
    @PostMapping("/recommendSit")   
    @ResponseBody
    public String recommendSit(@RequestBody PeopleNumber peopleNumber ) throws JsonProcessingException {
        BFSchoice bfs = new BFSchoice();
        return Jackson.classtoJson(sitSelectServiceImpl.adjust( sitSelectServiceImpl.selectAllChair(("diningtable_1".equals(peopleNumber.getRegion()))?"diningtable_1":"diningtable_2"),bfs.BFS(sitSelectServiceImpl.selectAllChair(("diningtable_1".equals(peopleNumber.getRegion()))?"diningtable_1":"diningtable_2"),peopleNumber.getPeopleNumber())));
    }

}

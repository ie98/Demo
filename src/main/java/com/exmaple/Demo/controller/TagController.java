package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.model.Tag;
import com.exmaple.Demo.service.TagServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@CrossOrigin(origins = {"http://localhost:9000","http://localhost:9001"})
public class TagController {
        @Autowired
        private TagServiceImpl labelService;
        @PostMapping("/selectAllTag")
        public String selectAllTag(@RequestBody Query query) throws JsonProcessingException {
            return Jackson.classtoJson(labelService.selectAllTag(query));
        }
        @PostMapping("/getTagTree")
        public String getTagTree(@RequestBody Query query) throws JsonProcessingException {
                return Jackson.classtoJson(labelService.getTagTree(query));
        }
        @PostMapping("/addTag/{tagname}/{pid}")
        public String addTag(@PathVariable("tagname") String tagneme,@PathVariable("pid") int pid ) throws JsonProcessingException {
                System.out.println("468446846");
                return Jackson.classtoJson(labelService.addTag(tagneme,pid));
        }
        @PostMapping("/selectAllTagNotQuery")
        public String selectAllTagNotQuery() throws JsonProcessingException {
                return Jackson.classtoJson(labelService.selectAllTagNotQuery());
        }
        @PostMapping("/selectAllTagNotQueryClient")//无需权限
        public String selectAllTagNotQueryClient() throws JsonProcessingException {
                return Jackson.classtoJson(labelService.selectAllTagNotQuery());
        }



}

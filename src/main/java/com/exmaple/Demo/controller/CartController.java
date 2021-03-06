package com.exmaple.Demo.controller;

import com.exmaple.Demo.dto.Cart;
import com.exmaple.Demo.dto.CartItem;
import com.exmaple.Demo.dto.UserId;
import com.exmaple.Demo.dto.deleteCartItem;
import com.exmaple.Demo.model.RedisCart;
import com.exmaple.Demo.service.CartServiceImpl;
import com.exmaple.Demo.util.Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:9000")
//@CrossOrigin("http://30j75285x8.qicp.vip")
public class CartController {
    @Autowired
    CartServiceImpl cartService;
    @PostMapping("/addCart")
    public String addCart(@RequestBody Cart cart ) throws JsonProcessingException {
        return Jackson.classtoJson(cartService.addCart(cart));
    }


    @PostMapping("/getCart")
    public String getCart(@RequestBody UserId userId) throws JsonProcessingException {
    System.out.println(userId.getId());
    String str = Jackson.classtoJson(cartService.getCart(userId.getId()));
    System.out.println(str);
        return str;
    }
    @PostMapping("/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable("id") int id,@RequestBody deleteCartItem item) throws JsonProcessingException {

        String str = Jackson.classtoJson(cartService.deleteCartItem(item,id));

        return str;
    }

}

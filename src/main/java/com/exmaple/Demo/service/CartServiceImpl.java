package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.Cart;
import com.exmaple.Demo.dto.CartItem;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.deleteCartItem;
import com.exmaple.Demo.model.RedisCart;
import com.exmaple.Demo.util.Jackson;
import com.exmaple.Demo.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public Meta addCart(Cart cart) {
        RedisUtil redisUtil = new RedisUtil(redisTemplate);

        String str = "Cart_"+cart.getId();
        System.out.println("111111");
        RedisCart temp  = (RedisCart) redisUtil.get(str);
        System.out.println("22222222");
        if (temp !=null){
            cart.getCart().setDate(new Date());
            temp.getCart().add(cart.getCart());
            redisUtil.set(str,temp);
        }else{
            RedisCart redisCart = new RedisCart();
            cart.getCart().setDate(new Date());
            redisCart.getCart().add(cart.getCart());
            redisCart.setId(cart.getId());
            redisUtil.set(str, redisCart);
        }
        return new Meta("SUCCESS");

    }

    @Override
    public RedisCart getCart(int id) throws JsonProcessingException {
        RedisUtil redisUtil = new RedisUtil(redisTemplate);

        String str = "Cart_"+id;
        System.out.println("111111");
        RedisCart temp  = (RedisCart) redisUtil.get(str);
        String str1 = Jackson.classtoJson(temp);
        System.out.println(str1);
        return temp;
    }
    public Meta deleteCartItem(deleteCartItem cartItem , int id){
        try {
            RedisUtil redisUtil = new RedisUtil(redisTemplate);
            RedisCart redisCart = (RedisCart) redisUtil.get("Cart_"+id);
            Iterator<CartItem> it =redisCart.getCart().iterator();
            while (it.hasNext()){
                CartItem cartItem1 = it.next();
                if (cartItem.getDate().getTime() ==  cartItem1.getDate().getTime()){
                    it.remove();
                }
            }
            redisUtil.set("Cart_"+id,redisCart);
            return new Meta("SUCCESS");
        }catch (Exception e){
            return new Meta("ERROR");
        }


    }
}

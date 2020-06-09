package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.Cart;
import com.exmaple.Demo.dto.CartItem;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.model.RedisCart;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CartService {
    public Meta addCart(Cart cart);

    public RedisCart getCart(int id) throws JsonProcessingException;
}

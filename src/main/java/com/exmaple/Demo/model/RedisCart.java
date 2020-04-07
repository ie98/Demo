package com.exmaple.Demo.model;

import com.exmaple.Demo.dto.CartItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedisCart {
    private List<CartItem> cart = new ArrayList<>();
    private int id;

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

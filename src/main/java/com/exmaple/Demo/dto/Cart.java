package com.exmaple.Demo.dto;


public class Cart {
    private CartItem cart;
    private int id;



    public CartItem getCart() {
        return cart;
    }

    public void setCart(CartItem cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

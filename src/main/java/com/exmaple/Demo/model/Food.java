package com.exmaple.Demo.model;

import lombok.Data;

@Data
public class Food {
    private int id;
    private String foodname;
    private int foodid;
    private double price;
    private int shopid;
    private String shopname;
    private String laber;
    private String img;
    private boolean forbid;

}

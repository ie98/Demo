package com.exmaple.Demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Food {
    private int id;
    private String foodname;
    private int foodid;
    private double price;
    private int shopid;
    private String shopname;
    private String tags;
    private String img;
    private boolean forbid;
    private List<List<Integer>> tagList = new ArrayList<>();
    private List<Tag> tagDetail = new ArrayList<>();

}

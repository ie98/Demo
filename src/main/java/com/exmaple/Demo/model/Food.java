package com.exmaple.Demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Food {
    private Integer id;
    private String foodname;
    private Integer foodid;
    private double price;
    private Integer shopid;
    private String shopname;
    private String tags;
    private String img;
    private boolean forbid;
    private List<List<Integer>> tagList = new ArrayList<>();
    private List<Tag> tagDetail = new ArrayList<>();
    private Integer needtime;

}

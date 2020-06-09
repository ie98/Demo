package com.exmaple.Demo.dto;


import java.util.Date;
public class CartItem {
    private int id;
    private String foodname;
    private int foodid;
    private double price;
    private int shopid;
    private String shopname;
    private String laber;
    private String img;
    private int num;
    private Date date;
    private Integer needtime;

    public Integer getNeedtime() {
        return needtime;
    }

    public void setNeedtime(Integer needtime) {
        this.needtime = needtime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getLaber() {
        return laber;
    }

    public void setLaber(String laber) {
        this.laber = laber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

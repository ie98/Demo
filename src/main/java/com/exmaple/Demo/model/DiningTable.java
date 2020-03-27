package com.exmaple.Demo.dto;

import java.util.ArrayList;

public class DiningTable {
    private int tableNumber;
    private ArrayList<chair> chairs = new ArrayList<chair>();

    public ArrayList<chair> getChairs() {
        return chairs;
    }

    public void setChairs(ArrayList<chair> chairs) {
        this.chairs = chairs;
    }
}

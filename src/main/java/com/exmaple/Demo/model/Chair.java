package com.exmaple.Demo.model;

import java.util.Date;

public class Chair {
    private int id;
    private long intable;
    private long chairnumber;
    private Boolean empty;
    private Date sittime;
    private Boolean recommendSit = true;

    public Boolean getRecommendSit() {
        return recommendSit;
    }

    public void setRecommendSit(Boolean recommendSit) {
        this.recommendSit = recommendSit;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", intable=" + intable +
                ", chairnumber=" + chairnumber +
                ", empty=" + empty +
                ", sittime=" + sittime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIntable() {
        return intable;
    }

    public void setIntable(long intable) {
        this.intable = intable;
    }

    public long getChairnumber() {
        return chairnumber;
    }

    public void setChairnumber(long chairnumber) {
        this.chairnumber = chairnumber;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Date getSittime() {
        return sittime;
    }

    public void setSittime(Date sittime) {
        this.sittime = sittime;
    }
}
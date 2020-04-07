package com.exmaple.Demo.model;

import java.io.Serializable;
import java.util.Date;

public class Chair implements Serializable {
    private int id;
    private int intable;
    private int chairnumber;
    private Boolean empty = true;
    private Date sittime;
    private Boolean recommendSit = false;
    private Boolean absempty ;

    public void setAbsempty(Boolean absempty) {
        this.absempty = absempty;
    }

    public Boolean getAbsempty() {
        return absempty;
    }

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
                ", recommendSit=" + recommendSit +
                ", absempty=" + absempty +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntable() {
        return intable;
    }

    public void setIntable(int intable) {
        this.intable = intable;
    }

    public int getChairnumber() {
        return chairnumber;
    }

    public void setChairnumber(int chairnumber) {
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
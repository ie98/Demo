package com.exmaple.Demo.model;

import java.io.Serializable;
import java.util.*;

public class DiningTable implements Serializable {
    private int id;
    private String location;
    private int surplusnumber;
    private int sumnumber;
    private List<Chair> chairs ;

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", surplusnumber=" + surplusnumber +
                ", sumnumber=" + sumnumber +
                '}';
    }
    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSurplusnumber() {
        return surplusnumber;
    }

    public void setSurplusnumber(int surplusnumber) {
        this.surplusnumber = surplusnumber;
    }

    public int getSumnumber() {
        return sumnumber;
    }

    public void setSumnumber(int sumnumber) {
        this.sumnumber = sumnumber;
    }
}

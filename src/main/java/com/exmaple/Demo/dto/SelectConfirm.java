package com.exmaple.Demo.dto;

import com.exmaple.Demo.model.DiningTable;

import java.util.List;
import java.util.PrimitiveIterator;

public class SelectConfirm {
    private List<DiningTable> tables;
    private String location;
    private int userId;
    private IdAndName[] allPeopleName;
    private String token;
    private int peopleNumber;

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public IdAndName[] getAllPeopleName() {
        return allPeopleName;
    }

    public void setAllPeopleName(IdAndName[] allPeopleName) {
        this.allPeopleName = allPeopleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<DiningTable> getTables() {
        return tables;
    }

    public void setTables(List<DiningTable> tables) {
        this.tables = tables;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.exmaple.Demo.dto;

public class PeopleNumber {
    private int peopleNumber;
    private String token;
    private String region;
    private IdAndName[] allPeopleName;


    public IdAndName[] getAllPeopleName() {
        return allPeopleName;
    }

    public void setAllPeopleName(IdAndName[] allPeopleName) {
        this.allPeopleName = allPeopleName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

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
}

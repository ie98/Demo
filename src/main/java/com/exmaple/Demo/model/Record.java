package com.exmaple.Demo.model;

import java.util.Date;

public class Record {
    private int id;
    private String username;
    private String location;
    private String allpeople;
    private int peoplenumber;
    private String grade;
    private String college;
    private Date indate;
    private String phone;
    private String sit;
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAllpeople() {
        return allpeople;
    }

    public void setAllpeople(String allpeople) {
        this.allpeople = allpeople;
    }

    public int getPeoplenumber() {
        return peoplenumber;
    }

    public void setPeoplenumber(int peoplenumber) {
        this.peoplenumber = peoplenumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSit() {
        return sit;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }
}

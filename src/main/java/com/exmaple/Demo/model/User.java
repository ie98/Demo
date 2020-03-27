package com.exmaple.Demo.model;

public class User {
    private int id;
    private String accountid;
    private String username;
    private String token;
    private Long gmtcreate;
    private Long gmtmodified;
    private String avatarurl;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountid='" + accountid + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", gmtcreate=" + gmtcreate +
                ", gmtmodified=" + gmtmodified +
                ", avatarurl='" + avatarurl + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtcreate() {
        return gmtcreate;
    }

    public void setGmtcreate(Long gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    public Long getGmtmodified() {
        return gmtmodified;
    }

    public void setGmtmodified(Long gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

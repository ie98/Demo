package com.exmaple.Demo.dto;
import  com.exmaple.Demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserQueryReturn {
    private List<User> users = new ArrayList<>();
    private int num;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

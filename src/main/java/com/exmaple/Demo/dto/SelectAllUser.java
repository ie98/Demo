package com.exmaple.Demo.dto;
import com.exmaple.Demo.model.User;

import java.util.List;

public class SelectAllUser {
    private List<User> allUser;

    public List<User> getAllUser() {
        return allUser;
    }

    public void setAllUser(List<User> allUser) {
        this.allUser = allUser;
    }
}

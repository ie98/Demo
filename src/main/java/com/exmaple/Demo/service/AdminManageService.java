package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.Meta;

import com.exmaple.Demo.model.User;

public interface AdminManageService {
    public Meta deleteUser(int id);
    public Meta editUser(User user);
}

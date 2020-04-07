package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.AdminLoginResult;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.model.Admin;

public interface AdminLoginService {
    public AdminLoginResult loginCheck(Admin admin);
}

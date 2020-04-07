package com.exmaple.Demo.service;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.model.User;

public interface LoginService {
    public LoginResult loginCheck(User user);

}

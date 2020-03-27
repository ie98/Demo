package com.exmaple.Demo.service;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.LoginMeta;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.mapper.UserMapper;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.exmaple.Demo.model.User;

import java.util.UUID;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Override
    public LoginResult loginCheck(User user){
        LoginResult loginToken = new LoginResult();
      User res =  userMapper.check(user.getUsername(),user.getPassword());
        System.out.println(res.toString());
        if (res != null){
            loginToken.setToken(UUID.randomUUID().toString());
            res.setToken(loginToken.getToken());
            System.out.println(ResultCode.getMessage("SUCCESS"));
            userMapper.SetUserToken(loginToken.getToken(), res.getUsername());
            loginToken.setMeta(new LoginMeta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")));
 //          System.out.println(loginToken.getToken());
        }else{
            loginToken.setMeta(new LoginMeta(ResultCode.getMessage("ERROR"),ResultCode.getCode("ERROR")));
        }
      return loginToken;
    }

}

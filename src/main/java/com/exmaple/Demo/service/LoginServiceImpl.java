package com.exmaple.Demo.service;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.exmaple.Demo.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginResult loginCheck(User user){
        LoginResult loginToken = new LoginResult();
      User res =  userMapper.check(user.getUsername(),user.getPassword());
      loginToken.setUserId(res.getId());
        System.out.println(res.toString());
        if (res != null){
            loginToken.setToken(UUID.randomUUID().toString());
            res.setToken(loginToken.getToken());
            System.out.println(ResultCode.getMessage("SUCCESS"));
            userMapper.SetUserToken(loginToken.getToken(), res.getUsername());
            loginToken.setMeta(new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")));
 //          System.out.println(loginToken.getToken());
        }else{
            loginToken.setMeta(new Meta(ResultCode.getMessage("ERROR"),ResultCode.getCode("ERROR")));
        }
      return loginToken;
    }

}

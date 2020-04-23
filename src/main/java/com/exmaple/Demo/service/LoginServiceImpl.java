package com.exmaple.Demo.service;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.mapper.UserMapper;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        //--------------------------------shiro认证
        System.out.println("12345");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            loginToken.setMeta(new Meta("SUCCESS"));
            subject.login(token);
        }catch (UnknownAccountException e){   //用户名不存在
            System.out.println("用户名不存在");
            loginToken.setMeta(new Meta("USER_NOT_REGISTER"));
            return loginToken;
        }

        //--------------------------------个人认证

      User res =  userMapper.check(user.getUsername(),user.getPassword());
        if (res != null){
            loginToken.setUserId(res.getId());
            if(res.getState()){
                loginToken.setToken(UUID.randomUUID().toString());
                res.setToken(loginToken.getToken());
                System.out.println(ResultCode.getMessage("SUCCESS"));
                userMapper.SetUserToken(loginToken.getToken(), res.getUsername());
                loginToken.setMeta(new Meta("SUCCESS"));
            }else{
                loginToken.setMeta(new Meta("USER_FORBIDDEN"));

            }
        }else {
            loginToken.setMeta(new Meta("USER_NOT_REGISTER"));

        }


      return loginToken;
    }

}

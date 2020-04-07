package com.exmaple.Demo.util;

import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Check {
    @Autowired
    private UserMapper userMapper;
    public  User tokenCheck(String token,int id){
        User user = userMapper.tokenCheck(token , id);
        System.out.println(user.toString());
        if (user==null)
            return null;
        else

    return user;
    }
}

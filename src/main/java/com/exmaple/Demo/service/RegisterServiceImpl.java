package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.RegisterUser;
import com.exmaple.Demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean insertUser(RegisterUser user) {
        String res = userMapper.checkRegisterName(user.getUsername());
        if (user.getUsername().equals(res)) {
            return false;
        } else {
            userMapper.insertUser(user.getUsername(), user.getPassword());
            return true;
        }

    }
}

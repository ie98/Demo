package com.exmaple.Demo.service;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.AdminLoginResult;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.mapper.AdminMapper;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public AdminLoginResult loginCheck(Admin admin) {
        AdminLoginResult adminLoginResult = new AdminLoginResult();
        Admin res =  adminMapper.check(admin.getUsername(),admin.getPassword());

        if (res != null){
            adminLoginResult.setAuthority(res.getAuthority());
            adminLoginResult.setShopename(res.getShopname());
            adminLoginResult.setUsername(res.getUsername());
            adminLoginResult.setUserId(res.getId());
            System.out.println(res.toString());
            adminLoginResult.setToken(UUID.randomUUID().toString());
            res.setToken(adminLoginResult.getToken());
            System.out.println(ResultCode.getMessage("SUCCESS"));
            adminMapper.SetAdminToken(adminLoginResult.getToken(), res.getUsername());
            adminLoginResult.setMeta(new Meta(ResultCode.getMessage("SUCCESS"),ResultCode.getCode("SUCCESS")));
            //          System.out.println(loginToken.getToken());
        }else{
            adminLoginResult.setMeta(new Meta(ResultCode.getMessage("ERROR"),ResultCode.getCode("ERROR")));
        }
        return adminLoginResult;
    }
}

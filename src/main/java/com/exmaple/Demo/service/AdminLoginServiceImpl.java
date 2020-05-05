package com.exmaple.Demo.service;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.AdminLoginResult;
import com.exmaple.Demo.dto.LoginResult;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.mapper.AdminMapper;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        //---------------------------shiro处理登录验证

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUsername(),admin.getPassword());
        try {
            subject.login(token);
        }catch (UnknownAccountException e){   //用户名不存在
            System.out.println("用户名不存在");
            adminLoginResult.setMeta(new Meta("ERROR"));
            return adminLoginResult;
        }
        //---------------------------个人处理登录验证
        Admin res =  adminMapper.check(admin.getUsername(),admin.getPassword());
//        Subject subject = SecurityUtils.getSubject();
        if (res != null){
            if(res.getState() == true){
                adminLoginResult.setAuthority(res.getAuthority());
                adminLoginResult.setShopename(res.getShopname());
                adminLoginResult.setUsername(res.getUsername());
                adminLoginResult.setUserId(res.getId());
                System.out.println(res.toString());
//            adminLoginResult.setToken(token.toString());
                adminLoginResult.setToken(UUID.randomUUID().toString());
                res.setToken(adminLoginResult.getToken());
                System.out.println(ResultCode.getMessage("SUCCESS"));
                adminMapper.SetAdminToken(adminLoginResult.getToken(), res.getUsername());
                adminLoginResult.setMeta(new Meta("SUCCESS"));
                //          System.out.println(loginToken.getToken());
            }else {
                adminLoginResult.setMeta(new Meta("USER_FORBIDDEN"));
            }

        }else{
            adminLoginResult.setMeta(new Meta("ERROR"));
        }
        return adminLoginResult;
    }
}

package com.exmaple.Demo.service;

import com.exmaple.Demo.constant.ResultCode;
import com.exmaple.Demo.dto.Meta;

import com.exmaple.Demo.mapper.AdminMapper;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exmaple.Demo.model.User;
@Service
public class AdminManageServiceImpl implements  AdminManageService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    /*----------------------------User--------------------*/
    public Meta deleteUser(int id){
        Boolean bool = userMapper.deleteUser(id);
        System.out.println("1");
        return bool==true?new Meta(ResultCode.getMessage("USER_DELETE_SUCCESS"),ResultCode.getCode("USER_DELETE_SUCCESS")):
                new Meta(ResultCode.getMessage("USER_DELETE_ERROR"),ResultCode.getCode("USER_DELETE_ERROR"));
    }
    public Meta editUser(User user){
        if (userMapper.selectUserByNameAndId(user.getUsername() , user.getId()).size() != 0){
            System.out.println(userMapper.selectUserByNameAndId(user.getUsername() , user.getId()).get(0).toString());
            return new Meta(ResultCode.getMessage("USER_HAS_EXISTED"),ResultCode.getCode("USER_HAS_EXISTED"));

        }

        Boolean bool =  userMapper.editUser(user);
        return bool==true?new Meta(ResultCode.getMessage("EDIT_SUCCESS"),ResultCode.getCode("EDIT_SUCCESS")):
                new Meta(ResultCode.getMessage("EDIT_ERROR"),ResultCode.getCode("EDIT_ERROR"));

    }
    /*----------------------------------Admin----------------------*/
    public Meta deleteAdmin(int id){
        Boolean bool = adminMapper.deleteAdmin(id);
        System.out.println("1");
        return bool==true?new Meta(ResultCode.getMessage("USER_DELETE_SUCCESS"),ResultCode.getCode("USER_DELETE_SUCCESS")):
                new Meta(ResultCode.getMessage("USER_DELETE_ERROR"),ResultCode.getCode("USER_DELETE_ERROR"));
    }
    public Meta editAdmin(Admin admin){
        if (adminMapper.selectAdminByNameAndId(admin.getUsername() , admin.getId()).size() != 0){
            System.out.println(adminMapper.selectAdminByNameAndId(admin.getUsername() , admin.getId()).get(0).toString());
            return new Meta(ResultCode.getMessage("USER_HAS_EXISTED"),ResultCode.getCode("USER_HAS_EXISTED"));

        }

        Boolean bool =  adminMapper.editAdmin(admin);
        return bool==true?new Meta(ResultCode.getMessage("EDIT_SUCCESS"),ResultCode.getCode("EDIT_SUCCESS")):
                new Meta(ResultCode.getMessage("EDIT_ERROR"),ResultCode.getCode("EDIT_ERROR"));

    }

}

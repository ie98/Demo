package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.UserQuery;
import com.exmaple.Demo.dto.UserQueryReturn;
import com.exmaple.Demo.mapper.AdminMapper;
import com.exmaple.Demo.mapper.RecordMapper;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public UserQueryReturn selectAllUser(UserQuery userQuery) {
        System.out.println(userQuery.getPageSize());
        List<User> users = userMapper.selectAllUser();
        int start = userQuery.getPageSize()*(userQuery.getPageNum()-1);
        int end = start +userQuery.getPageSize();
        UserQueryReturn userQueryReturn = new UserQueryReturn();
        if (userQuery.getPageNum() == 1 && end >= users.size())
            userQueryReturn.getUsers().addAll(users);
        else
        {
            for (int i = start; i < end; i++) {
                    if(i>=users.size()) break;
                userQueryReturn.getUsers().add(users.get(i));
            }
        }

        userQueryReturn.setNum(users.size());
        return userQueryReturn;
    }

    @Override
    public List<Admin> selectAllAdmin() {
        List<Admin> admins = adminMapper.selectAllAdmin();
        return admins;
    }

    @Override
    public List<Record> selectAllRecord() {
        List<Record> records = recordMapper.selectAllRecord();
        return records ;
    }
    public Boolean updateUserState(User user){
        Boolean bool = userMapper.updateState(user.getId());
        return bool ;
    }
    public Boolean updateAdminState(Admin admin){
        Boolean bool = adminMapper.updateState(admin.getId());
        return bool ;
    }
    public List<User> selectUser(String query){
        List<User> user = userMapper.selectUserByName(query);
        return user==null?null:user;
    }
    public Admin selectAdmin(String query){
        Admin admin = adminMapper.selectAdminByName(query);
        return admin==null?null:admin;
    }
}

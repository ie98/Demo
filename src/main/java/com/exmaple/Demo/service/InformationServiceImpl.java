package com.exmaple.Demo.service;

import com.exmaple.Demo.mapper.AdminMapper;
import com.exmaple.Demo.mapper.RecordMapper;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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
    public List<User> selectAllUser() {
        List<User> users = userMapper.selectAllUser();
        return users;
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
}

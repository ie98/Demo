package com.exmaple.Demo.service;

import java.util.List;

import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.model.User;
public interface InformationService {
    public List<User> selectAllUser();
    public List<Admin> selectAllAdmin();
    public List<Record> selectAllRecord();
}

package com.exmaple.Demo.service;

import java.util.List;

import com.exmaple.Demo.dto.UserQuery;
import com.exmaple.Demo.dto.UserQueryReturn;
import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.model.User;
public interface InformationService {
    public UserQueryReturn selectAllUser(UserQuery userQuery);
    public List<Admin> selectAllAdmin();
    public List<Record> selectAllRecord();
    public Boolean updateUserState(User user);
    public Boolean updateAdminState(Admin admin);
    public List<User> selectUser(String query);
}

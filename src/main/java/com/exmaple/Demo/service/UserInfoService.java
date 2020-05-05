package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;
import com.exmaple.Demo.model.User;

import java.util.List;

public interface UserInfoService {
    public Meta updatePassword(String password , int id);
    public QueryReturn selectFoodRecordById(Query query,int id);
    public User userInfoById(int id);
    public QueryReturn sitRecordInfoById(Query query ,String name);

}

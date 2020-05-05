package com.exmaple.Demo.service;

import com.exmaple.Demo.mapper.RecordMapper;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.model.User;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;
import com.exmaple.Demo.mapper.FoodRecordMapper;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.FoodRecord;
import com.exmaple.Demo.util.Result;
import com.exmaple.Demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FoodRecordMapper foodRecordMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public Meta updatePassword(String password, int id) {
        System.out.println(password + " " + id);
        return Result.ResuleInfo(userMapper.updatePassword(password,id)) ;
    }

    @Override
    public QueryReturn selectFoodRecordById(Query query,int id) {
        List<FoodRecord> foodRecords = foodRecordMapper.selectAllFoodRecordByUserId(id);
        QueryReturn queryReturn = Utils.selectUtil(foodRecords , query);
        queryReturn.setMeta(Result.ResuleInfo(true));
        return queryReturn;
    }

    @Override
    public User userInfoById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public QueryReturn sitRecordInfoById(Query query, String name) {
        List<Record> sitRecord  = recordMapper.selectRecordByName(name);
        QueryReturn queryReturn =  Utils.selectUtil(sitRecord,query);
        queryReturn.setMeta(Result.ResuleInfo(true));
        return queryReturn;
    }
}

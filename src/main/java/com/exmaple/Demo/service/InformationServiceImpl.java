package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;

import com.exmaple.Demo.mapper.*;
import com.exmaple.Demo.model.*;

import com.exmaple.Demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl<T> implements InformationService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private ShopMapper shopMapper;
    private Utils utils = new Utils();
    @Override
    public QueryReturn selectAllUser(Query query) {
        System.out.println(query.getPageSize());
        List<User> list = userMapper.selectAllUser();
        return utils.selectUtil((List<T>) list,query);
    }

    @Override
    public QueryReturn selectAllAdmin(Query query) {
        System.out.println(query.getPageSize());
        List<Admin> list = adminMapper.selectAllAdmin();

        return utils.selectUtil((List<T>) list,query);
    }

    @Override
    public QueryReturn selectAllRecord(Query query) {
        List<Record> list = recordMapper.selectAllRecord();
        return utils.selectUtil((List<T>) list,query);
    }

    @Override
    public QueryReturn selectAllShop(Query query) {
        List<Shop> list = shopMapper.selectAllShop();
        return utils.selectUtil((List<T>) list,query);
    }

    @Override
    public QueryReturn selectAllFood(Query query) {
        List<Food> list = foodMapper.selectAllFood();
        return utils.selectUtil((List<T>) list,query);
    }

    @Override
    public Boolean updateShopState(Shop shop) {
        Boolean bool = shopMapper.updateForbid(shop.getId());
        return bool ;
    }

    @Override
    public Boolean updateFoodState(Food food) {
        Boolean bool = foodMapper.updateForbid(food.getId());
        return bool ;
    }

    public Boolean updateUserState(User user){
        Boolean bool = userMapper.updateState(user.getId());
        return bool ;
    }
    @Override
    public Boolean updateAdminState(Admin admin){
        Boolean bool = adminMapper.updateState(admin.getId());
        return bool ;
    }

    @Override
    public User selectUser(String query){
        User user = userMapper.selectUserByName(query);
        return user==null?null:user;
    }

    @Override
    public List<Record> selectRecord(String query) {
        List<Record> record = recordMapper.selectRecordByName(query);
        return record.size() == 0?null:record;
    }
    @Override
    public Admin selectAdmin(String query){
        Admin admin = adminMapper.selectAdminByName(query);
        return admin==null?null:admin;
    }

    @Override
    public Shop selectShop(String query) {
        Shop shop = shopMapper.selectShopByName(query);
        return shop == null?null:shop;
    }

    @Override
    public Food selectFood(String query) {
        Food food = foodMapper.selectFoodByName(query);
        return food == null ?null:food;
    }



}

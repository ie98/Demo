package com.exmaple.Demo.service;

import java.util.List;

import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;
import com.exmaple.Demo.model.*;

public interface InformationService {
    public QueryReturn selectAllUser(Query query);

    public QueryReturn selectAllAdmin(Query query);

    public QueryReturn selectAllRecord(Query query);
    public QueryReturn selectAllFoodRecord(Query query ,String shopname);

    public QueryReturn selectAllShop(Query query);
    public QueryReturn selectAllFood(Query query);
    public List<Food> selectAllFoodNotQuery();
    public Boolean updateUserState(User user);

    public Boolean updateAdminState(Admin admin);
    public Boolean updateShopState(Shop shop);

    public Boolean updateFoodState(Food food);

    public User selectUser(String query);
    public Admin selectAdmin(String query);
    public Shop selectShop(String query);
    public Food selectFood(String query);
    public List<Record> selectRecord(String query);


}

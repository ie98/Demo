package com.exmaple.Demo.service;

import com.alipay.api.request.AftAifinNewtestQueryRequest;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;

import com.exmaple.Demo.mapper.*;
import com.exmaple.Demo.model.*;

import com.exmaple.Demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private FoodRecordMapper foodRecordMapper;
    private Utils utils = new Utils();
    @Override
    public QueryReturn selectAllUser(Query query) {
        System.out.println(query.getPageSize());
        List<User> list = userMapper.selectAllUser();
            return utils.selectUtil(list,query);
    }

    @Override
    public QueryReturn selectAllAdmin(Query query) {
        System.out.println(query.getPageSize());
        List<Admin> list = adminMapper.selectAllAdmin();

        return utils.selectUtil(list,query);
    }

    @Override
    public QueryReturn selectAllRecord(Query query) {
        List<Record> list = recordMapper.selectAllRecord();
        return utils.selectUtil(list,query);
    }

    @Override
    public QueryReturn selectAllShop(Query query) {
        List<Shop> list = shopMapper.selectAllShop();
        return utils.selectUtil(list,query);
    }

    @Override
    public QueryReturn selectAllFood(Query query) {
        List<Food> foods = foodMapper.selectAllFood();
        List<Tag> tags = tagMapper.selectAllTag();
        if (foods == null){
            QueryReturn queryReturn = new QueryReturn();
            queryReturn.setMeta(new Meta("ERROR"));
            return queryReturn;
        }
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i).getTags());
            if (foods.get(i).getTags() == null ||  "".equals(foods.get(i).getTags())) {
            }else {
                String[] str  = foods.get(i).getTags().split("/");
                List<List<Integer>> list = new ArrayList<>();
                for (int i1 = 0; i1 < str.length; i1++) {
                    String[] arr = str[i1].split(",");
                    List<Integer> temp = new ArrayList<>();
                    for (int i2 = 0; i2 < arr.length; i2++) {
                        temp.add(Integer.parseInt(arr[i2]));
                    }
                    list.add(temp);
                }
                foods.get(i).setTagList(list);
            }
        }
        QueryReturn queryReturn = utils.selectUtil(foods,query);
        Object tempFoods = queryReturn.getList(); // 先转Object再转List<Food> List<A>无法直接强制转换成List<B>
        List<Food> needFoods = (List<Food>)tempFoods;
        for (int i = 0; i < needFoods.size(); i++) {
            for (List<Integer> taglist : needFoods.get(i).getTagList()) {
                for (int i1 = 0; i1 < tags.size(); i1++) {
                    if (tags.get(i1).getId() == taglist.get(taglist.size()-1)){
                        needFoods.get(i).getTagDetail().add(tags.get(i1));
                        break;
                    }
                }
            }
        }
        Object object = needFoods;
        List<Object> list = (List<Object>) object;
        queryReturn.setList(list);
        return queryReturn;
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

    @Override
    public List<Food> selectAllFoodNotQuery() {
        List<Food> foods = foodMapper.selectAllFood();

        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getTags() !=null || ! "".equals(foods.get(i).getTags())){
                String[] str  = foods.get(i).getTags().split("/");
                List<List<Integer>> list = new ArrayList<>();
                for (int i1 = 0; i1 < str.length; i1++) {
                    String[] arr = str[i1].split(",");
                    List<Integer> temp = new ArrayList<>();
                    for (int i2 = 0; i2 < arr.length; i2++) {
                        temp.add(Integer.parseInt(arr[i2]));
                    }
                    list.add(temp);
                }
                foods.get(i).setTagList(list);
            }
        }
        return foods;
    }

    @Override
    public QueryReturn selectAllFoodRecord(Query query , String shopname) {
        System.out.println(shopname);
        List<FoodRecord> list = foodRecordMapper.selectAllFoodRecordByShopname(shopname);
        System.out.println(list.size());
        QueryReturn queryReturn = Utils.selectUtil(list,query);
        return queryReturn;
    }
}

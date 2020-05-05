package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.FoodsAndMeta;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.mapper.FoodMapper;
import com.exmaple.Demo.mapper.TagMapper;
import com.exmaple.Demo.model.Food;
import com.exmaple.Demo.model.Tag;
import com.exmaple.Demo.util.Result;
import com.exmaple.Demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientFoodServiceImpl implements ClientFoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Food> selectAllFood() {
        return foodMapper.selectAllFood();
    }

    @Override
    public FoodsAndMeta showTheShopFood(String shopname) {
        FoodsAndMeta foodsAndMeta = new FoodsAndMeta();

        if (foodMapper.showTheShopFood(shopname).size() != 0 ){
            List<Food> foods = foodMapper.showTheShopFood(shopname);
            List<Tag> tags = tagMapper.selectAllTag();
            if (foods == null){
                foodsAndMeta.setMeta(new Meta("ERROR"));
                return foodsAndMeta;
            }
            Utils.tagStringToObject(tags,foods);//将Sting表示的标签转为List<Tag>表示，并放在对应的food中
            foodsAndMeta.setFoods(foods);
            foodsAndMeta.setMeta(Result.ResuleInfo(true));
        }else
            foodsAndMeta.setMeta(Result.ResuleInfo(false));

        return foodsAndMeta;
    }

    @Override
    public List<Food> selectTagFood(List<List<Integer>> list) {
        List<Food> foods = foodMapper.selectAllFood();
        List<Food> res = new ArrayList<>();
        Utils.tagStringToObject(tagMapper.selectAllTag(),foods);
        List<Integer> lastInt = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(list.get(i).size() - 1));
            lastInt.add(list.get(i).get(list.get(i).size()-1));
        }
        int out = 0;
        for (int i = 0; i < foods.size(); i++) {
            out = 0;
            if(foods.get(i).getTagList() == null)
                break;
            System.out.println("foods.get(i).getTagList().size():"+foods.get(i).getTagList().size());
            for (int i1 = 0; i1 < foods.get(i).getTagList().size(); i1++) {
                System.out.println(i1);
                if (foods.get(i).getTagList().get(i1) == null)
                    break;
                for (int i2 = 0; i2 < foods.get(i).getTagList().get(i1).size(); i2++) {

                    for (int i3 = 0; i3 < lastInt.size(); i3++) {

                        if (foods.get(i).getTagList().get(i1).get(i2).equals(lastInt.get(i3))){
                            res.add(foods.get(i));
                            out = 1;
                        }
                        if (out == 1)
                            break;
                    }
                    if (out == 1)
                        break;
                }
                if (out == 1)
                    break;
            }
        }
        return res;
    }
}

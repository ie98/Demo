package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.FoodsAndMeta;
import com.exmaple.Demo.model.Food;

import java.util.List;

public interface ClientFoodService {
    public List<Food> selectAllFood();
    public FoodsAndMeta showTheShopFood(String shopname);
    public List<Food>  selectTagFood(List<List<Integer>> list);

}

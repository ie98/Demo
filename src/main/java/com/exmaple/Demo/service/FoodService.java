package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.FoodsAndMeta;
import com.exmaple.Demo.model.Food;

import java.util.List;

public interface FoodService {
    public List<Food> selectAllFood();
    public FoodsAndMeta showTheShopFood(String shopname);

}

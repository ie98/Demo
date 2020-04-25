package com.exmaple.Demo.dto;

import com.exmaple.Demo.model.Food;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FoodsAndMeta {
    private List<Food> foods = new ArrayList<>();
    private Meta meta ;
}

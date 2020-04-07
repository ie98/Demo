package com.exmaple.Demo.service;

import com.exmaple.Demo.mapper.FoodMapper;
import com.exmaple.Demo.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements  FoodService {
    @Autowired
    private FoodMapper foodMapper;
    public List<Food> selectAllFood() {
      List<Food> foods = foodMapper.selectAllFood();
//      Food[][] foods1 = new Food[0][];
//      int j = 0;
//      for (int i = 0 ; i< foods.size() ;i++){
//          if (i+1%6 == 0) j++;
//          foods1[j][i%6] = foods.get(i);
//          System.out.println(j+"-"+i%6+":"+foods1[j][i%6]);
//      }

//        for (int i = 0; i < foods1.length ; i++) {
//
//        }
      return foods;
    }

}

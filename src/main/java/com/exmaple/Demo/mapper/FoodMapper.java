package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface FoodMapper {
    @Select("select * from food where foodid = #{foodid}")
    List<Food> selectFood(@Param("foodid") int foodid);
    @Select("select * from food ")
    List<Food> selectAllFood();
    @Select("select * from food where shopid = #{shopid}")
    List<Food> selectShopFood(@Param("shopid") int shopid);
}

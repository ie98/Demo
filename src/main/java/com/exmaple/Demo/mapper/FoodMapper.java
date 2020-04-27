package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Food;

import com.exmaple.Demo.model.Shop;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
@Component
public interface FoodMapper {
    @Select("select * from food where foodid = #{foodid}")
    List<Food> selectFood(@Param("foodid") int foodid);
    @Select("select * from food  where foodname = #{name}")
    Food selectFoodByName(@Param("name") String name);
    @Select("select * from food ")
    List<Food> selectAllFood();
    @Select("select * from food where shopid = #{shopid}")
    List<Food> selectShopFood(@Param("shopid") int shopid);
    @Delete("delete from food where id = #{id}")
    Boolean deleteFood(@Param("id") int id);
    @Insert("insert into food (id,foodid,foodname,price,shopname,img) values (#{id},#{foodid},#{foodname},#{price},#{shopname},#{img})")
    Boolean insertFood(Food food);
    @Update("update food set foodname = #{foodname} , price = #{price} ,shopname = #{shopname} , tags = #{tags}where id = #{id} ")
    Boolean updateFood(Food food);
    @Update("update food set  forbid = not forbid where id = #{id} ")
    Boolean updateForbid(@Param("id") int id);
    @Update("update food set  img = #{img} where foodname = #{foodname} ")
    Boolean updateImg(@Param("foodname") String foodname , @Param("img") String img);
    @Select("select * from food where shopname = #{shopname}")
    List<Food> showTheShopFood(@Param("shopname") String shopname);
}

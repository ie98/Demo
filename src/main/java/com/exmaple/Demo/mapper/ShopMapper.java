package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Food;
import com.exmaple.Demo.model.Shop;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@Repository
public interface ShopMapper {
    @Select("select * from shop ")
    List<Shop> selectAllShop();
    @Select("select * from shop  where shopname = #{name}")
    Shop selectShopByName(@Param("name") String name);
    @Select("select * from shop  where shopname = #{name} and id <> #{id}")
    Shop selectShopByNameAndId(@Param("name") String name , @Param("id") int id);
    @Delete("delete from shop where id = #{id}")
    Boolean deleteShop(@Param("id") int id);
    @Insert("insert into shop (shopid,shopname,described,notice,principal,phone) values (#{shopid},#{shopname},#{described},#{notice},#{principal},#{phone})")
    Boolean insertShop(Shop shop);
    @Update("update shop set  shopname = #{shopname} , described = #{described}, phone = #{phone} , principal = #{principal} , notice = #{notice} where id = #{id} ")
    Boolean updateShop(Shop shop);
    @Update("update shop set  forbid = not forbid where id = #{id} ")
    Boolean updateForbid(@Param("id") int id);
}

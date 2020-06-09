package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.FoodRecord;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodRecordMapper {
    @Insert("insert into foodrecord (subject,total_amount,out_trade_no,body,product_code,username,date,userid,allneedtime) values (#{subject},#{total_amount},#{out_trade_no},#{body},#{product_code},#{username},#{date},#{userid},#{allneedtime})")
    public Boolean insertFoodRecord(FoodRecord foodRecord);
    @Select("select * from foodrecord")
    public List<FoodRecord> selectAllFoodRecord();
    @Select("select * from foodrecord where userid = #{id}")
    public List<FoodRecord> selectAllFoodRecordByUserId(@Param("id") int id);
    @Select("select * from foodrecord where subject = #{shopname}")
    public List<FoodRecord> selectAllFoodRecordByShopname(@Param("shopname") String shopname);
    @Update("update foodrecord set dispose = 1 where id = #{id}")
    public Boolean disposeFoodRecord(@Param("id") int id);
    @Select("select * from foodrecord where id = #{id}")
    public FoodRecord selectFoodRecordById(@Param("id") int id);

}

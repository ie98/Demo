package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.FoodRecord;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodRecordMapper {
    @Insert("insert into foodrecord (subject,total_amount,out_trade_no,body,product_code,username,date,userid) values (#{subject},#{total_amount},#{out_trade_no},#{body},#{product_code},#{username},#{date},#{userid})")
    public Boolean insertFoodRecord(FoodRecord foodRecord);
    @Select("select * from foodrecord")
    public List<FoodRecord> selectAllFoodRecord();
    @Select("select * from foodrecord where userid = #{id}")
    public List<FoodRecord> selectAllFoodRecordByUserId(@Param("id") int id);
}

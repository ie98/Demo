package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.FoodRecord;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FoodRecordMapper {
    @Insert("insert into foodrecord (subject,total_amount,out_trade_no,body,product_code,username,date,userid) values (#{subject},#{total_amount},#{out_trade_no},#{body},#{product_code},#{username},#{date},#{userid})")
    public Boolean insertFoodRecord(FoodRecord foodRecord);
}

package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Chair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ChairMapper {
    @Select("select * from chair_1 ")
    List<Chair> selectAllChairsOne();
    @Select("select * from chair_2 ")
    List<Chair> selectAllChairsTwo();
    @Select("select * from chair where intable = 1 and chairnumber = 3")
    Chair selectOne();
    @Update("update chair_1 set empty = false where id = #{id}")
    void setEmptyOnChair1(@Param("id") int id);
    @Update("update chair_2 set empty = false where id = #{id}")
    void setEmptyOnChair2(@Param("id") int id);
}

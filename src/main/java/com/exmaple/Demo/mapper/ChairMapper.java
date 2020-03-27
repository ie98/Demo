package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Chair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
}

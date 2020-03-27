package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.DiningTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TaberMapper {
    @Select("select * from diningtable_1")
    List<DiningTable> selectAllTableOne();
    @Select("select * from diningtable_2")
    List<DiningTable> selectAllTableTwo();

}

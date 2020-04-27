package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
    @Select("select * from tag ")
    List<Tag> selectAllTag();
    @Insert("insert into tag (pid , level ,tagname ) values (#{pid},#{level},#{tagname})")
    Boolean addTag(Tag label);
    @Select("select level from tag where id = #{id}")
    Integer getLevelById(@Param("id") int id);
}

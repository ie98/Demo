package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface RecordMapper {
    @Insert("insert into record (username,peoplenumber,grade,indate,location,allpeople,college,sit,phone,remarks) values (#{username},#{peoplenumber},#{grade},#{indate},#{location},#{allpeople},#{college},#{sit},#{phone},#{remarks})")
    void insertRecord(Record record);
    @Select("select * from record")
    List<Record> selectAllRecord ();
}

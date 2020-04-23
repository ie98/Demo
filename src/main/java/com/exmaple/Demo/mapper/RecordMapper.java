package com.exmaple.Demo.mapper;

import com.exmaple.Demo.dto.RemarksAndId;
import com.exmaple.Demo.model.Record;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface RecordMapper {
    @Insert("insert into record (username,peoplenumber,grade,indate,location,allpeople,college,sit,phone,remarks) values (#{username},#{peoplenumber},#{grade},#{indate},#{location},#{allpeople},#{college},#{sit},#{phone},#{remarks})")
    void insertRecord(Record record);
    @Select("select * from record")
    List<Record> selectAllRecord ();
    @Delete("delete from record where id = #{id}")
    Boolean deleteRecrdById(@Param("id") int id );
    @Update("update record set remarks = #{remarks} where id = #{id}")
    Boolean updateRecordById(@Param("id") int id ,@Param("remarks") String remarks);
    @Select("select * from record where username = #{username}")
    List<Record> selectRecordByName(@Param("username") String username);
    @Update("update record set remarks = #{remarks} where id = #{id}")
    Boolean editRemarks(RemarksAndId remarks);
}

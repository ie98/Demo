package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface AdminMapper {
    @Select("select * from administrator where username = #{username} and password = #{password}")
    Admin check (@Param("username") String username , @Param("password") String password);
    @Update("update administrator set token = #{token} where username = #{username}")
    void SetAdminToken(@Param("token") String token , @Param("username") String username);
    @Select("select * from Administrator")
    List<Admin> selectAllAdmin ();
    @Select("select * from administrator where username = #{name}")
    Admin selectAdminByName(@Param("name") String name);
    @Delete("delete from administrator where id = #{id}")
    Boolean deleteAdmin (@Param("id") int id);
    @Select("select * from administrator where username = #{username} and id <> #{id}")
    List<Admin> selectAdminByNameAndId(@Param("username") String username , @Param("id") int id);
    @Update("update administrator set username = #{username} , authority = #{authority} , shopname = #{shopname},password = #{password},phone = #{phone} where  id = #{id}")
    Boolean editAdmin(Admin admin);
    @Insert("insert into administrator (username,authority,shopname,password,phone,) values(#{username},#{authority},#{shopname},#{password},#{phone})")
    Boolean insertAdmin(Admin admin);
    @Update("update administrator set state = not state where id = #{id} ")
    Boolean updateState(@Param("id") int id);
}

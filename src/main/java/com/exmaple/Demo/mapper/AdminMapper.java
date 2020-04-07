package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Admin;
import com.exmaple.Demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

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
}
